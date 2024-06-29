package com.igrowker.cvinter.service;

import com.igrowker.cvinter.model.dto.UserDTO;
import com.igrowker.cvinter.model.entity.User;

public interface IUserService {
    UserDTO getUserByEmail(String email);
    boolean checkCredentials(String email, String password);
}
