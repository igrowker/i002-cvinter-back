package com.igrowker.cvinter.service;

import org.springframework.stereotype.Service;


import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import com.igrowker.cvinter.model.repository.TwoFactorAuthRepository;
import com.igrowker.cvinter.security.TwoFactorAuthData;


@Service
public abstract class TwoFactorAuthImplementation implements ITwoFactorAuthService {

    private final TwoFactorAuthRepository twoFactorAuthenticationRepository;

    public TwoFactorAuthImplementation(TwoFactorAuthRepository twoFactorAuthenticationRepository) {
        this.twoFactorAuthenticationRepository = twoFactorAuthenticationRepository;
    }

    @Override
    public void send2FACode(String userId) {
        String twoFactorCode = generate2FACode();

        Date expirationTime = new Date(System.currentTimeMillis() + 300000); 
        
        
        TwoFactorAuthData twoFactorAuthenticationData = new TwoFactorAuthData(userId, twoFactorCode, expirationTime);
        twoFactorAuthenticationRepository.save(twoFactorAuthenticationData);

        
    }

    private String generate2FACode() {
    SecureRandom random = new SecureRandom();
    byte[] bytes = new byte[32]; 
    random.nextBytes(bytes);
    return Base64.getUrlEncoder().encodeToString(bytes);
}


}

