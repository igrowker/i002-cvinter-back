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
        System.err.println("LLEGA A ACA");
        User user = userRepository.findByEmail(email);

        System.err.println(user);

        List<User> users = userRepository.findAll();

        System.err.println(users);

        if (user == null) {
            return null;
        }
        return user.toDTO();
    }
}
