package com.igrowker.cvinter.service;

import com.igrowker.cvinter.model.dto.CVDTO;
import com.igrowker.cvinter.model.dto.GetUserDTO;
import com.igrowker.cvinter.model.dto.RegisterUserDTO;
import com.igrowker.cvinter.model.dto.UserDTO;
import com.igrowker.cvinter.model.entity.Role;
import com.igrowker.cvinter.model.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
    GetUserDTO getUserByEmail(String email);
    ResponseEntity<String> registerUser(RegisterUserDTO registerUserDTO);
    ResponseEntity<String> updateUser (UserDTO userDTO);
    boolean checkCredentials(String email, String password);
    int uploadCV(CVDTO cv);
    Role getUserRole(String email);
    List<UserDTO> getUsersByTech(String tech);
    List<UserDTO> getUsersByLocation(String ubicacion);
    List<UserDTO> getUsersByTitle(String title);
}
