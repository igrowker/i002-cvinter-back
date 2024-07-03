package com.igrowker.cvinter.service;

import com.igrowker.cvinter.model.dto.InterviewDTO;
import com.igrowker.cvinter.model.entity.Interview;

import java.util.List;

public interface IInterviewService {
    public List<InterviewDTO> getAllInterviews();

    public InterviewDTO getInterviewById(long interviewId);

}
