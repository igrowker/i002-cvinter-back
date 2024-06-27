package com.igrowker.cvinter.controller;

import com.igrowker.cvinter.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IUserService userService;

    @Autowired
    private SecretKey secretKey;


    @PostMapping("/login")
    public ResponseEntity<?> login() {
        return new ResponseEntity<>("Login", HttpStatus.OK);
    }


    @PostMapping("/register")
    public ResponseEntity<?> register() {
        return new ResponseEntity<>("Login", HttpStatus.OK);
    }

    @PostMapping("/2fa")
    public ResponseEntity<?> twoFactor() {
        return new ResponseEntity<>("Login", HttpStatus.OK);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword() {
        return new ResponseEntity<>("Login", HttpStatus.OK);
    }

}
