package com.urbanladder.utility;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {
	
	public static void main(String[] args) throws IOException {
		//sendMail();
	}
	
	public static void sendMail(File file) throws IOException {
		
		
		
		//Recepient's Email Address
		String to = PropertyFileUtil.loadFile().getProperty("sendemailtoid");
		
		//Sender's Email Address
		final String fromid = PropertyFileUtil.loadFile().getProperty("sendemailfromid");
		
		//Sender's Email Password
		final String frompass = PropertyFileUtil.loadFile().getProperty("sendemailfrompass");
		
		
		//SMTP Host Name
		String host = "smtp.gmail.com";
		
		//Get System Properties
		Properties prop = System.getProperties();
		
		//Setup Mail server
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.auth", "true");
		
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(fromid, frompass);

            }
            
        });	
   
     // Send the actual HTML message.
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(fromid));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");
            
            Multipart mult = new MimeMultipart();
            
            MimeBodyPart attachmentPart = new MimeBodyPart();

            MimeBodyPart textPart = new MimeBodyPart();
            
            try {

                
                attachmentPart.attachFile(file);
                textPart.setText("This is text");
                mult.addBodyPart(textPart);
                mult.addBodyPart(attachmentPart);

            } catch (IOException e) {

                e.printStackTrace();

            }
            
            message.setContent(mult);

//            // Now set the actual message
//            message.setText("This is actual message");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
		
	}
        
}



