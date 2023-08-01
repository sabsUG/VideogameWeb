/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Videogames.service;

import jakarta.mail.MessagingException;

/**
 *
 * @author arianasaboriom
 */
public interface EmailService {
    public void sendHtmlEmail(
            String recipient, 
            String subject, 
            String Htmlcontent) 
            throws MessagingException;

}
