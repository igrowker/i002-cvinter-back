package com.igrowker.cvinter.service;

import com.igrowker.cvinter.model.dto.RegisterUserDTO;
import com.igrowker.cvinter.model.dto.UserDTO;
import com.igrowker.cvinter.model.entity.User;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    UserDTO getUserByEmail(String email);
    ResponseEntity<String> registerUser(RegisterUserDTO registerUserDTO);
    ResponseEntity<String> updateUser (UserDTO userDTO);
    boolean checkCredentials(String email, String password);
}
