package com.igrowker.cvinter.service;

import com.igrowker.cvinter.model.dto.RegisterUserDTO;
import com.igrowker.cvinter.model.dto.UserDTO;
import com.igrowker.cvinter.model.entity.User;
import com.igrowker.cvinter.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(registerUserDTO.getPassword());

        User user = new User(registerUserDTO.getEmail(),encodedPassword,registerUserDTO.getFullName());

        userRepository.save(user);

        return new ResponseEntity<>("User created successfully",HttpStatus.CREATED);
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




    private boolean checkPassword (String password, String passwordDB){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return (passwordEncoder.matches(password, passwordDB));
    }
}
