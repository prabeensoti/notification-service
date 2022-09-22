package edu.miu.cs590.notificationservice.controller;

import edu.miu.cs590.notificationservice.dto.EmailSenderDto;
import edu.miu.cs590.notificationservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/email/push")
    public String paymentNotification(@RequestBody EmailSenderDto emailSenderDto){
       emailService.paymentNotification(emailSenderDto);
       return "SUCCESS";
    }

}
