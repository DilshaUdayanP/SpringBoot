package org.geekster.email;

import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class EmailTemplate {
    public static void main(String[] args)
    {
        //System.out.println("Hello world!");
        String FromAddress = "dilshaudayan@gmail.com";
        String ToAddress = "dileshprintn@gmail.com";
        String CcAddress = "dilshaudayanp@gmail.com";
        try{
            sendWithoutAttachment("Welcome to geekster email without attachment demo session",FromAddress,ToAddress,CcAddress);
            sendWithAttachment("Welcome to geekster email with attachment demo session",FromAddress,ToAddress,CcAddress);
        }
        catch (MessagingException | IOException msgex)
        {
            System.out.println("Oops!! Exception occurred : "+msgex);
        }
    }

    public static void sendWithoutAttachment(String MessageBody,String FromAddress,String ToAddress,String CcAddress) throws MessagingException
    {
        Session session = getsession();

        //Compose the mail or create an email
        MimeMessage message = new MimeMessage(session);
        message.setFrom(FromAddress);
        message.addRecipients(Message.RecipientType.TO,ToAddress);
        message.addRecipients(Message.RecipientType.CC,CcAddress);
        message.setSubject("Geekster mail demo");
        message.setText(MessageBody);

        //Send the mail
        Transport.send(message);
        System.out.println("Mail Send Successfully!.......");
    }

    private static Session getsession()
    {
        //creating an object for the properties of current machine
        Properties properties = System.getProperties();

        //set the properties of service provider[gmail] machine to our machine
        // 1. host name, 2. Port number, 3. SSL level, 4. authentication

        //Host name [mail.smtp.host] for gmail : smtp.gmail.com
        properties.put("mail.smtp.host", "smtp.gmail.com");

        //Port number [mail.smtp.port] for gmail it is used for specific position or location in server
        properties.put("mail.smtp.port", "465");

        //SSL level [mail.smtp.ssl.enable] for gmail : true
        properties.put("mail.smtp.ssl.enable", "true");

        //Authentication [mail.smtp.auth] for gmail : true
        properties.put("mail.smtp.auth", "true");


        //create the session : trying to establish a connection with service provider
        //Anonymous function
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("dilshaudayan@gmail.com",Constant.PASSWORD);
            }
        });

        return session;
    }

    public static void sendWithAttachment(String MessageBody,String FromAddress,String ToAddress,String CcAddress) throws MessagingException, IOException {
        Session session = getsession();

        //Compose the mail or create an email
        MimeMessage message = new MimeMessage(session);
        message.setFrom(FromAddress);
        message.addRecipients(Message.RecipientType.TO,ToAddress);
        message.addRecipients(Message.RecipientType.CC,CcAddress);
        message.setSubject("Geekster mail demo with attachment");

        //Adding attachment for the mail
        MimeMultipart multimedia = new MimeMultipart();

        //for body text
        MimeBodyPart bodyText = new MimeBodyPart();
        bodyText.setText(MessageBody);

        //for media
        MimeBodyPart bodyAttachment = new MimeBodyPart();
        String path ="C:/Users/user/Downloads/Dilsha_P_ISA.pdf";
        File file = new File(path);
        bodyAttachment.attachFile(file);

        //append text and media to multimedia
        multimedia.addBodyPart(bodyText);
        multimedia.addBodyPart(bodyAttachment);

        //add all data to message
        message.setContent(multimedia);

        //Send the mail
        Transport.send(message);
        System.out.println("Mail with attachment Send Successfully!.......");
    }
}