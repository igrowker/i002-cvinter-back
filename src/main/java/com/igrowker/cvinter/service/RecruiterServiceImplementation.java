package com.igrowker.cvinter.service;

import com.igrowker.cvinter.model.dto.UserDTO;
import com.igrowker.cvinter.model.repository.UserRepository;
import com.igrowker.cvinter.model.entity.Recruiter;
import com.igrowker.cvinter.model.entity.User;
import com.igrowker.cvinter.model.repository.RecruiterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecruiterServiceImplementation implements IRecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getCandidates() {

        List<User> users = userRepository.findAll();
        List<UserDTO> candidates = new ArrayList<>();

        if (!users.isEmpty()) {
            for (User user : users) {
                if (!user.getRole().toString().equals("CANDIDATE"))
                    candidates.add(user.toDTO());
            }
        }
        return candidates;
    }
}
