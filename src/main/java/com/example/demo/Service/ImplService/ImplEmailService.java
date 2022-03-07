package com.example.demo.Service.ImplService;

import com.example.demo.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@EnableAsync
@Service
public class ImplEmailService implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    @Async
    public void sendSimpleMessage(String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("conradinho2000@mail.ru");
        message.setText(text);
        message.setSubject("SpringTest");
        mailSender.send(message);
    }
}
