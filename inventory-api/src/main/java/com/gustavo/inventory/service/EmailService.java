package com.gustavo.inventory.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendLowStockAlert(String productName, int quantity) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("alert_recipient@example.com");  // Replace with your alert email
        message.setSubject("Low Stock Alert: " + productName);
        message.setText("Warning! The stock for product '" + productName + "' is low. Current quantity: " + quantity);

        mailSender.send(message);
    }
}
