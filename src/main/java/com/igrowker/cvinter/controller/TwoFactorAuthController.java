package com.igrowker.cvinter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igrowker.cvinter.service.ITwoFactorAuthService;
import com.igrowker.cvinter.security.TwoFactorAuthRequest;





public class TwoFactorAuthController {
    @RestController
public class TwoFactorAuthenticationController {

    private final ITwoFactorAuthService twoFactorAuthenticationService;

    public TwoFactorAuthenticationController(ITwoFactorAuthService twoFactorAuthenticationService) {
        this.twoFactorAuthenticationService = twoFactorAuthenticationService;
    }

    @PostMapping("/api/auth/2fa")
    public ResponseEntity<Void> send2FACode(@RequestBody TwoFactorAuthRequest request) {
        twoFactorAuthenticationService.send2FACode(request.getUserId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/auth/2fa/verify")
    public ResponseEntity<Void> verify2FACode(@RequestBody TwoFactorAuthenticationVerificationRequest request) {
        boolean isValid = twoFactorAuthenticationService.verify2FACode(request.getUserId(), request.getTwoFactorCode());
        if (isValid) {
            // Código válido
            // ... realizar la acción deseada (por ejemplo, iniciar sesión)
            return ResponseEntity.ok().build();
        } else {
            // Código inválido
            return ResponseEntity.badRequest().build();
        }
    }
}

}
