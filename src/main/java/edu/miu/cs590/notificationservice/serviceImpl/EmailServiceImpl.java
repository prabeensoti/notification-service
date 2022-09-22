package edu.miu.cs590.notificationservice.serviceImpl;

import edu.miu.cs590.notificationservice.dto.EmailSenderDto;
import edu.miu.cs590.notificationservice.entity.Email;
import edu.miu.cs590.notificationservice.repository.EmailRepository;
import edu.miu.cs590.notificationservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    EmailRepository emailRepository;


    @Override
    public void paymentNotification(EmailSenderDto emailSenderDto) {
            Email email = new Email();
            email.setSender(emailSenderDto.getSender());
            email.setTo(emailSenderDto.getTo());
            email.setSubject(emailSenderDto.getSubject());
            email.setMessage(emailSenderDto.getMessage());
            email.setSendStatus(false);
            email.setCreatedDate(new Date());
            emailRepository.save(email);
    }
}
