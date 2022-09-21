package edu.miu.cs590.notificationservice.serviceImpl;

import edu.miu.cs590.notificationservice.dto.EmailSenderDto;
import edu.miu.cs590.notificationservice.entity.Email;
import edu.miu.cs590.notificationservice.repository.EmailRepository;
import edu.miu.cs590.notificationservice.service.EmailService;
import edu.miu.cs590.notificationservice.util.NotificationUtility;
import edu.miu.cs590.notificationservice.util.EmailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    EmailRepository emailRepository;


    @Override
    public EmailResponse paymentNotification(EmailSenderDto emailSenderDto) {
        try{
            Email email = new Email();
            email.setSender(emailSenderDto.getSender());
            email.setTo(emailSenderDto.getTo());
            email.setSubject(emailSenderDto.getSubject());
            email.setMessage(emailSenderDto.getMessage());
            email.setSendStatus(false);
            email.setCreatedDate(new Date());

            emailRepository.save(email);

            return NotificationUtility.getSuccessfulServerResponse(true,"Email persists");
        }catch (Exception e){
            return NotificationUtility.getFailedServerResponse("Mail send failed!!");
        }
    }
}
