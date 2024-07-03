package com.igrowker.cvinter.model.repository;

import com.igrowker.cvinter.model.entity.Interview;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InterviewRepository extends MongoRepository<Interview, String>{

    Interview findById(Long interviewId);

    List<Interview> findByRecruiterId(Long recruiterId);
}

