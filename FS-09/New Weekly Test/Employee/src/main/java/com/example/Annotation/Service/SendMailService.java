package com.example.Annotation.Service;

import com.example.Annotation.DAO.Employee_Email_DAO;
import com.example.Annotation.Model.Email;
import org.springframework.stereotype.Service;
import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class SendMailService {


    @Autowired private static JavaMailSender javaMailSender;

    @Value("${spring.mail.username}") private static String sender;

    public static String sendMail(Email details)
    {
        String message = Employee_Email_DAO.getAllEmployees().toString();
        try {
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(message);
            mailMessage.setSubject(details.getSubject());

            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }
}
