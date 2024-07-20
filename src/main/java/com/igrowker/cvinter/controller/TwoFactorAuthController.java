package com.igrowker.cvinter.controller;

import com.igrowker.cvinter.security.TwoFactorAuthenticationRequest;
import com.igrowker.cvinter.security.TwoFactorAuthenticationVerificationRequest;
import com.igrowker.cvinter.service.ITwoFactorAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class TwoFactorAuthController {

    private final ITwoFactorAuthService twoFactorAuthenticationService;

    public TwoFactorAuthController(ITwoFactorAuthService twoFactorAuthenticationService) {
        this.twoFactorAuthenticationService = twoFactorAuthenticationService;
    }

    @PostMapping("/2fa")
    public ResponseEntity<Void> enableTwoFactorAuthentication(@RequestBody TwoFactorAuthenticationRequest request) {
        twoFactorAuthenticationService.enableTwoFactorAuthentication(request.getUserId(), request.getSecretKey());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/2fa/verify")
    public ResponseEntity<Void> verifyTwoFactorAuthenticationCode(@RequestBody TwoFactorAuthenticationVerificationRequest request) {
        boolean validCode = twoFactorAuthenticationService.verifyTwoFactorAuthenticationCode(request.getUserId(), request.getCode());
        if (validCode) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
