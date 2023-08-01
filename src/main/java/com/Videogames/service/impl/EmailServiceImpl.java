/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Videogames.service.impl;

import com.Videogames.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author arianasaboriom
 */
@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender mailSender;

    
    @Override
    public void sendHtmlEmail(String recipient, 
            String subject, 
            String Htmlcontent) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper 
                = new MimeMessageHelper(message, 
                        true);
        helper.setTo(recipient);
        helper.setSubject(subject);
        helper.setText(Htmlcontent,true);
        mailSender.send(message);
    }
    
}
