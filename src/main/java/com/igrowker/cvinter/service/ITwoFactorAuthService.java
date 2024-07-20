package com.igrowker.cvinter.service;


public interface ITwoFactorAuthService {

    void enableTwoFactorAuthentication(String userId, String secretKey);

    boolean verifyTwoFactorAuthenticationCode(String userId, String code);
    
}
