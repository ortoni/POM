package utils;


import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class TriggerEmail {
	public static void triggerEmail(String files) throws MessagingException, AddressException, IOException {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");    
		props.put("mail.smtp.socketFactory.port", "465");    
		props.put("mail.smtp.socketFactory.class",    
				"javax.net.ssl.SSLSocketFactory");    
		props.put("mail.smtp.auth", "true");    
		props.put("mail.smtp.port", "465"); 
		Session session = Session.getDefaultInstance(props,  new Authenticator() {  
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {  
				return new PasswordAuthentication("testleaf0150@gmail.com","leaf@123");  
			}
		} 				);	
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("testleaf0150@gmail.com"));
		msg.addRecipient(Message.RecipientType.TO,new  InternetAddress("koushik350@gmail.com"));
		msg.setHeader("Subject", "JavaXmail Test");
		msg.setText("Jenkins Job");

		MimeBodyPart body = new MimeBodyPart();
		String file = files;
		body.attachFile(file);
		Multipart mp = new MimeMultipart();
		mp.addBodyPart(body);
		msg.setContent(mp);

		Transport.send(msg);
		System.out.println("mail sent");
	}
}
