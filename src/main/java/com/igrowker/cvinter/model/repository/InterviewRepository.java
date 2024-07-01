package com.igrowker.cvinter.model.repository;

import com.igrowker.cvinter.model.entity.Interview;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface InterviewRepository extends MongoRepository<Interview, long>{

    Interview findById(Long interviewId);

    List<Interview> findAll();

    List<Interview> findByRecruiterId(Long recruiterId);
}

