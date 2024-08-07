package com.igrowker.cvinter.service;

import com.igrowker.cvinter.model.dto.CV.ExperienciaCV;
import com.igrowker.cvinter.model.dto.CV.PersonalInfoCV;
import com.igrowker.cvinter.model.dto.CV.TechSkillCV;
import com.igrowker.cvinter.model.dto.CVDTO;
import com.igrowker.cvinter.model.dto.GetUserDTO;
import com.igrowker.cvinter.model.dto.RegisterUserDTO;
import com.igrowker.cvinter.model.dto.UserDTO;
import com.igrowker.cvinter.model.entity.Role;
import com.igrowker.cvinter.model.entity.User;
import com.igrowker.cvinter.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplementation implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public GetUserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            return null;
        }
        return user.toDTO().toGetUserDTO();
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

        if (userDTO.getEmail() != null && !userDTO.getEmail().isEmpty()) user.setEmail(userDTO.getEmail());
        if (userDTO.getFullName() != null && !userDTO.getFullName().isEmpty()) user.setFullName(userDTO.getFullName());
        if (userDTO.getCv() != null) user.setCv(userDTO.getCv().toEntity());
        if (userDTO.getTwoFactorSecret() != null && !userDTO.getTwoFactorSecret().isEmpty()) user.setTwoFactorSecret(userDTO.getTwoFactorSecret());
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

    @Override
    public List<UserDTO> getUsersByTech(String tech) {

        List<User> users = userRepository.findAll();
        List<UserDTO> result = new ArrayList<>();

        for (User user : users) {
            List<TechSkillCV> techSkillCV = user.getCv().getTechSkills();
            for (TechSkillCV techSkill : techSkillCV) {
                if (techSkill.getSkill().equals(tech)) {
                    if (!result.contains(user.toDTO()))
                        result.add(user.toDTO());
                }
            }
        }

        if (result.isEmpty()) {
            return null;
        }
        return result;
    }

    @Override
    public List<UserDTO> getUsersByLocation(String ubicacion) {

        List<User> users = userRepository.findAll();
        List<UserDTO> result = new ArrayList<>();

        for (User user : users) {
            List<PersonalInfoCV> ubicaciones = user.getCv().getUbicaciones();
            for (PersonalInfoCV ubicacionUser : ubicaciones) {
                if (ubicacionUser.getIcon().equals("address") && ubicacionUser.getDato().equals(ubicacion)) {
                    if (!result.contains(user.toDTO()))
                        result.add(user.toDTO());
                }
            }
        }

        if (result.isEmpty()) {
            return null;
        }

        return result;
    }

    @Override
    public List<UserDTO> getUsersByTitle(String title) {

        List<User> users = userRepository.findAll();
        List<UserDTO> result = new ArrayList<>();

        for (User user : users) {
            List<ExperienciaCV> experiencias = user.getCv().getExperiencias();
            for (ExperienciaCV experiencia : experiencias) {
                if (experiencia.getProfesion().equals(title)){
                    if (!result.contains(user.toDTO()))
                        result.add(user.toDTO());
                }
            }
        }

        if (result.isEmpty()) {
            return null;
        }

        return result;
    }

    @Override
    public Role getUserRole(String email) {

        User user = userRepository.findByEmail(email);

        if (user == null) {
            return null;
        }
        if (user.getRole().toString().equals("ADMIN")) {
            return Role.ADMIN;
        }
        if (user.getRole().toString().equals("RECRUITER")) {
            return Role.RECRUITER;
        }
        if (user.getRole().toString().equals("CANDIDATE")) {
            return Role.CANDIDATE;
        }
        return null;
    }
}
