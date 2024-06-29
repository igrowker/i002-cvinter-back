package com.igrowker.cvinter.controller;

import com.igrowker.cvinter.model.dto.RegisterUserDTO;
import com.igrowker.cvinter.model.dto.UserLoginDTO;
import com.igrowker.cvinter.service.IUserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.util.Date;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final int EXPIRATION_TIME_IN_HOURS = 24;

    @Autowired
    private IUserService userService;

    @Autowired
    private SecretKey secretKey;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO credentials) {

        if (credentials == null)
            return new ResponseEntity<>("Credentials not sent", HttpStatus.BAD_REQUEST);
        else if (credentials.getEmail() == null || credentials.getPassword() == null)
            return new ResponseEntity<>("Credentials not sent", HttpStatus.BAD_REQUEST);

        if (userService.checkCredentials(credentials.getEmail(), credentials.getPassword())) {

            String token = Jwts.builder()
                    .setSubject(credentials.getEmail())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_IN_HOURS * 60 * 60 * 1000))
                    .signWith(secretKey, SignatureAlgorithm.HS256)
                    .compact();

            return new ResponseEntity<>(token, HttpStatus.OK);

        }
        else {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }

    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUsers (@RequestBody RegisterUserDTO registerUserDTO) {

        System.err.println(registerUserDTO.toString());

        if (registerUserDTO ==  null) {
            return new ResponseEntity<>("Data not sent", HttpStatus.BAD_REQUEST);
        }
        if (registerUserDTO.getEmail() == null || registerUserDTO.getEmail().isBlank()) {
            return new ResponseEntity<>("Email can't be blank", HttpStatus.BAD_REQUEST);
        }
        if (registerUserDTO.getPassword() == null || registerUserDTO.getPassword().isBlank()) {
            return new ResponseEntity<>("Password can't be blank", HttpStatus.BAD_REQUEST);
        }
        if (registerUserDTO.getFullName() == null || registerUserDTO.getFullName().isBlank()) {
            return new ResponseEntity<>("Fullname can't be blank", HttpStatus.BAD_REQUEST);
        }

        return userService.registerUser(registerUserDTO);
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
