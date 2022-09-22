package edu.miu.cs590.notificationservice.service;

import edu.miu.cs590.notificationservice.dto.EmailSenderDto;

public interface EmailService {
    void paymentNotification(EmailSenderDto emailSenderDto);
}
