package com.igrowker.cvinter.controller;


import com.igrowker.cvinter.model.dto.GetUserDTO;
import com.igrowker.cvinter.model.dto.RegisterUserDTO;
import com.igrowker.cvinter.model.dto.UserDTO;
import com.igrowker.cvinter.model.repository.UserRepository;
import com.igrowker.cvinter.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> uploadCv() { //! IMPLEMENTAR
        return new ResponseEntity<>("User", HttpStatus.OK);
    }


}
