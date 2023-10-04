package com.auca.email;

import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.Session;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
  private final String username;
  private final String password;
  private final Properties properties;

  public SendEmail(String username, String password) {
    this.username = username;
    this.password = password;
    this.properties = new Properties();
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.port", "587");
    properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
  }

  public void sendEmail(String recipientEmail, String subject, String text) throws MessagingException {
    Session session = Session.getInstance(properties, new Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
      }
    });

    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress(username));
    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
    message.setSubject(subject);
    message.setText(text);

    Transport.send(message);

  }
}