package com.igrowker.cvinter.service;

import com.igrowker.cvinter.model.dto.CVDTO;
import com.igrowker.cvinter.model.dto.RegisterUserDTO;
import com.igrowker.cvinter.model.dto.UserDTO;
import com.igrowker.cvinter.model.entity.User;
import com.igrowker.cvinter.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImplementation implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            return null;
        }
        return user.toDTO();
    }

    @Override
    public ResponseEntity<String> registerUser(RegisterUserDTO registerUserDTO) {

        if (userRepository.findByEmail(registerUserDTO.getEmail()) != null) {
            return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(registerUserDTO.getPassword());

        User user = new User();

        user.setEmail(registerUserDTO.getEmail());
        user.setPassword(encodedPassword);
        user.setFullName(registerUserDTO.getFullName());
        user.setTwoFactorEnabled(false);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setCv(null);
        user.setTwoFactorSecret("");

        userRepository.save(user);

        return new ResponseEntity<>("User created successfully",HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> updateUser(UserDTO userDTO) {

        User user = userRepository.findByEmail(userDTO.getEmail());

        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
            user.setPassword(encodedPassword);
        }

        user.setEmail(userDTO.getEmail());
        user.setFullName(userDTO.getFullName());
        user.setCv(userDTO.getCv().toEntity());
        user.setTwoFactorEnabled(userDTO.isTwoFactorEnabled());
        user.setTwoFactorSecret(userDTO.getTwoFactorSecret());
        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);


        return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
    }

    @Override
    public boolean checkCredentials(String email, String password) {

        User user = userRepository.findByEmail(email);

        if (user == null) {
            return false;
        }
        if (checkPassword(password, user.getPassword())) {
            return true;
        }

        return false;
    }

    @Override
    public int uploadCV(CVDTO cv) {

        User user = userRepository.findById(cv.getUserId()).orElse(null);

        if (user == null) {
            return 1;
        }

        user.setCv(cv.toEntity());

        userRepository.save(user);

        return 0;
    }

    private boolean checkPassword (String password, String passwordDB){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return (passwordEncoder.matches(password, passwordDB));
    }
}
