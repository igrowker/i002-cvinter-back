package com.igrowker.cvinter.controller;


import com.igrowker.cvinter.model.dto.CVDTO;
import com.igrowker.cvinter.model.dto.GetUserDTO;
import com.igrowker.cvinter.model.dto.RegisterUserDTO;
import com.igrowker.cvinter.model.dto.UserDTO;
import com.igrowker.cvinter.model.entity.Role;
import com.igrowker.cvinter.model.repository.UserRepository;
import com.igrowker.cvinter.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping("/me")
    public ResponseEntity<?> getUser(@RequestParam String email) {
        UserDTO user = userService.getUserByEmail(email);


        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.err.println(passwordEncoder.encode(user.getPassword()));

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/me")
    public ResponseEntity<?> updateUser() { //! IMPLEMENTAR
        return new ResponseEntity<>("User", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateMyProfile(@RequestBody UserDTO userDTO) {
        ResponseEntity<String> response = userService.updateUser(userDTO);
        return response;
    }

    @PostMapping("/upload-cv")
    public ResponseEntity<?> uploadCv(@RequestBody CVDTO cv) { //! IMPLEMENTAR

        int response = userService.uploadCV(cv);

        switch (response) {
            case 1:
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            case 2:
                return new ResponseEntity<>("CV uploaded successfully", HttpStatus.CREATED);
            case 3:
                return new ResponseEntity<>("CV updated successfully", HttpStatus.OK);
            default:
                return new ResponseEntity<>("Error uploading CV", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getUsersByTech")
    public ResponseEntity<?> getUsersByTech(@RequestParam String tech, @RequestParam String email) {

        Role userRole = userService.getUserRole(email);

        if (userRole != Role.RECRUITER) {
            return new ResponseEntity<>("You are not authorized to perform this action", HttpStatus.UNAUTHORIZED);
        }

        List<UserDTO> users = userService.getUsersByTech(tech);

        if (users == null || users.isEmpty()) {
            return new ResponseEntity<>("No users found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/getUsersByLocation")
    public ResponseEntity<?> getUsersByLocation(@RequestParam String location, @RequestParam String email) {

        Role userRole = userService.getUserRole(email);

        if (userRole != Role.RECRUITER) {
            return new ResponseEntity<>("You are not authorized to perform this action", HttpStatus.UNAUTHORIZED);
        }

        List<UserDTO> users = userService.getUsersByLocation(location);

        if (users == null || users.isEmpty()) {
            return new ResponseEntity<>("No users found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/getUsersByTitle")
    public ResponseEntity<?> getUsersByTitle(@RequestParam String title, @RequestParam String email) {

        Role userRole = userService.getUserRole(email);

        if (userRole != Role.RECRUITER) {
            return new ResponseEntity<>("You are not authorized to perform this action", HttpStatus.UNAUTHORIZED);
        }

        List<UserDTO> users = userService.getUsersByTitle(title);

        if (users == null || users.isEmpty()) {
            return new ResponseEntity<>("No users found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
