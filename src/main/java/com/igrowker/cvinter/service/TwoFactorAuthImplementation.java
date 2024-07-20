package com.igrowker.cvinter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.keygen.Base64StringKeyGenerator;
import com.igrowker.cvinter.model.repository.TwoFactorRepository;
import com.igrowker.cvinter.model.entity.TwoFactorAuth;



@Service
public class TwoFactorAuthImplementation implements ITwoFactorAuthService {

    @Autowired
  private TwoFactorRepository twoFactorRepository; // Repository to store user 2FA data

  @Autowired
  private UserDetailsService userDetailsService; // Service to retrieve user details by ID

  @Autowired
  private PasswordEncoder passwordEncoder; // Password encoder (implement based on your security configuration)

  private final Base64StringKeyGenerator keyGenerator = new Base64StringKeyGenerator(32); // Generate 32-byte secret key

  
    @Autowired
    private JavaMailSender emailSender;  


    @Override
        public void enableTwoFactorAuthentication(String userId, String password) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(userId);
            if (userDetails != null && passwordEncoder.matches(password, userDetails.getPassword())) {
            String secretKey = keyGenerator.generateKey();
            twoFactorRepository.save(new TwoFactorAuth(userId, secretKey)); 
          } 
        }

    @Override
    public boolean verifyTwoFactorAuthenticationCode(String userId, String code) {
        TwoFactorAuth twoFactorAuthentication = twoFactorRepository.findById(userId).orElse(null);
        if (twoFactorAuthentication != null) {
            String lastCode = twoFactorAuthentication.getLastCode();
            if (lastCode.equals(code)) {
                return true;
            }
        }
        return false;
    }

    private void sendTwoFactorAuthenticationCode(String userId, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("2FA@cvinter.com"); 
        message.setTo(userId);
        message.setSubject("Código de autenticación de dos factores");
        message.setText("Su código 2FA es: " + code);

        emailSender.send(message);  
    }
}
