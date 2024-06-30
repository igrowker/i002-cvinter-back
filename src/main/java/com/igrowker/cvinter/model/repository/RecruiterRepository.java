package com.igrowker.cvinter.model.repository;

import cvinter.igrowker.model.entity.Recruiter;
import cvinter.igrowker.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RecruiterRepository extends MongoRepository<Recruiter, String> {
  
    List<User> findUsersByfullNameOrEmail(String fullName, String email,);
    List<User> findAll();
    User findById(String userId);
    List<User> findRecruitedUsersByRecruiterId(String recruiterId);
    User findUserWithInterviews(String userId);
    List<Recruiter> findUsersByfullNameOrEmail(String fullName, String email,);
    List<Recruiter> findAll();
    Recruiter findById(String recruiterId);
}


