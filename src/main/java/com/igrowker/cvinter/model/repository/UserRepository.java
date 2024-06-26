package com.igrowker.cvinter.model.repository;

import com.igrowker.cvinter.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{

    User findByEmail(String email);
}
