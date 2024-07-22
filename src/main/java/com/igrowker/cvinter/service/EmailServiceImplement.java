package com.igrowker.cvinter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EmailServiceImplement implements EmailService {

    private static final Logger logger = Logger.getLogger(EmailServiceImplement.class.getName());
    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendSimpleEmail(String email, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
        logger.log(Level.INFO,"Email enviado a: {0}" , email);
    }
}
