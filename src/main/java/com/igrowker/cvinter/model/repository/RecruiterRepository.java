package com.igrowker.cvinter.model.repository;

import com.igrowker.cvinter.model.entity.Recruiter;
import com.igrowker.cvinter.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RecruiterRepository extends MongoRepository<Recruiter, String> {
    
//    User findById(String userId);
//    User findUserWithInterviews(String userId);
//    List<User> findRecruitedUsersByRecruiterId(String recruiterId);
//    List<User> findUsersByfullNameOrEmail(String fullName, String email,);
//    List<User> findAll();
//
//    Recruiter findById(String recruiterId);
//    List<Recruiter> findUsersByfullNameOrEmail(String fullName, String email,);
//    List<Recruiter> findAll();
}


