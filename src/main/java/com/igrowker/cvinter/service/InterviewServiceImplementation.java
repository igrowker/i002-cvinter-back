package com.igrowker.cvinter.service;

import com.igrowker.cvinter.model.dto.InterviewDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igrowker.cvinter.model.entity.Interview;
import com.igrowker.cvinter.model.repository.InterviewRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InterviewServiceImplementation implements IInterviewService {
   @Autowired
    private InterviewRepository interviewRepository;

    @Override
    public List<InterviewDTO> getAllInterviews() {

        List<Interview> interviews = interviewRepository.findAll();
        List<InterviewDTO> interviewDTOs = new ArrayList<>();

        if (interviews.isEmpty())
            return null;

        for (Interview interview: interviews){
            interviewDTOs.add(interview.toDTO());
        }

        return interviewDTOs;
    }

    @Override
    public InterviewDTO getInterviewById(long interviewId) {

        Interview interview = interviewRepository.findById(interviewId);

        if (interview != null) return interview.toDTO();
        else return null;
    }


}
