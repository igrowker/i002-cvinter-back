package com.igrowker.cvinter.service;

import com.igrowker.cvinter.model.dto.UserDTO;
import com.igrowker.cvinter.model.entity.User;
import com.igrowker.cvinter.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements IUserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            return null;
        }
        return user.toDTO();
    }
}
