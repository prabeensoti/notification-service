package edu.miu.cs590.notificationservice.service;

import edu.miu.cs590.notificationservice.dto.EmailSenderDto;
import edu.miu.cs590.notificationservice.util.EmailResponse;
import org.springframework.http.ResponseEntity;

public interface EmailService {
    EmailResponse paymentNotification(EmailSenderDto emailSenderDto);
}
