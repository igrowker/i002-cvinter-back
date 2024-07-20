
package com.igrowker.cvinter.model.repository;

import com.igrowker.cvinter.model.entity.TwoFactorAuth;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TwoFactorRepository extends MongoRepository<TwoFactorAuth, String> {

    TwoFactorAuth findByUserId(String userId);
}
