package com.igrowker.cvinter.service;

import com.igrowker.cvinter.service.exception.RecruiterNotFoundException;
import com.igrowker.cvinter.model.entity.Recruiter;
import com.igrowker.cvinter.model.entity.User;
import com.igrowker.cvinter.model.repository.RecruiterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecruiterServiceImplementation implements IRecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;

    @Override
    public List<User> getRecruitedUsersByRecruiterId(String recruiterId) {
        Recruiter recruiter = recruiterRepository.findById(recruiterId);
        if (recruiter != null) {
            List<User> recruitedUsers = recruiter.getRecruitedUsers();
            return recruitedUsers.stream()
                    .filter(user -> user.getStatus().equals("RECRUITED"))
                    .collect(Collectors.toList());
        } else {
            throw new RecruiterNotFoundException("Recruiter with ID " + recruiterId + " not found");
        }
    }

    
}
