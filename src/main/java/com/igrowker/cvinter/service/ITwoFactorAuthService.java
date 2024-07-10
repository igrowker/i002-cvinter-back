package com.igrowker.cvinter.service;


public interface ITwoFactorAuthService {

    void send2FACode(String userId);

    boolean verify2FACode(String userId, String twoFactorCode);
}
