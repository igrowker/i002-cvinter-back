package com.igrowker.cvinter.service;

import java.util.List;
import com.igrowker.cvinter.model.entity.Interview;
public interface InterviewService {

    List<Interview> getAllInterviews(); 

    List<Interview> findByUsuarioId(Long usuarioId);

    List<Interview> findByReclutadorId(Long reclutadorId); 

    List<Interview> getInterviewById(long interviewId)

  
}
