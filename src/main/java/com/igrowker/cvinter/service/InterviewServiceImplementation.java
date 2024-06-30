package com.igrowker.cvinter.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igrowker.cvinter.model.entity.Interview;
import com.igrowker.cvinter.model.repository.InterviewRepository;

@Service
public class InterviewServiceImplementation implements IInterviewService {
   @Autowired
    private InterviewRepository interviewRepository;

    @Override
    public List<Interview> getAllInterviews() {
        return InterviewRepository.findAll();
    }

    @Override
    public List<Interview> findByUserId(Long UserId) {
        return InterviewRepository.findByUsuarioId(UserId); o
    }

    @Override
    public List<Interview> findByRecruiterId(Long RecruiterId) {
        return InterviewRepository.findByReclutadorId(RecruiterId); 
    }

  
}
