package com.igrowker.cvinter.model.repository;

import com.igrowker.cvinter.security.TwoFactorAuthData;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TwoFactorAuthRepository extends MongoRepository<TwoFactorAuthData, String> {

    TwoFactorAuthData findByUserId(String userId);
}
