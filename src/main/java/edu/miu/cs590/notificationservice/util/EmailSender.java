package edu.miu.cs590.notificationservice.util;

import edu.miu.cs590.notificationservice.entity.Email;
import edu.miu.cs590.notificationservice.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Component
@Scope("singleton")
public class EmailSender {
    @Autowired
    private EmailRepository emailRepository;

    public void fetchEmailToSend(){
        System.out.println("Job is running..");
        List<Email> emails = emailRepository.findEmailToSend();
        emails.forEach(e-> setEmail(e));
    }

    private boolean setEmail(Email email){
        JavaMailSender emailSender = configureEmail();
        MimeMessage mimeMessage =emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        try{
            helper.setText(email.getMessage(),true);
            helper.setFrom(email.getSender());
            helper.setTo(email.getTo());
            helper.setSubject(email.getSubject());
        }
        catch (MessagingException e){
            e.printStackTrace();
        }

        try{
            emailSender.send(mimeMessage);
            email.setSendStatus(true);
            email.setSentDate(new Date());
            emailRepository.save(email);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    private JavaMailSender configureEmail(){
        JavaMailSenderImpl mailSender = setMailSender();
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        return mailSender;

    }

    private JavaMailSenderImpl setMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.mailtrap.io");
        mailSender.setPort(2525);

        mailSender.setUsername("9510a862d6b9cc");
        mailSender.setPassword("020374c1c08d88");
        return mailSender;
    }
}
