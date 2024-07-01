package com.igrowker.cvinter.service;

import java.util.List;
import com.igrowker.cvinter.model.entity.Interview;
public interface InterviewService {

    List<Interview> getAllInterviews(); 

    List<Interview> findByUserId(Long userId);

    List<Interview> findByRecruiterId(Long recruiterId); 

    List<Interview> getInterviewById(long interviewId)

  
}
