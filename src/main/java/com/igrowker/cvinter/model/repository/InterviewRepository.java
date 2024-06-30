package com.igrowker.cvinter.model.repository;

import com.igrowker.cvinter.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InterviewRepository extends MongoRepository<Interview, long>{

    Interview findById(Long id);

    List<Interview> findAll();

    List<Interview> findByReclutadorId(Long reclutadorId);
}
