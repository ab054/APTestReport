package tests;

import org.jsoup.Jsoup;
import org.testng.annotations.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by abarabas on 11/22/16.
 */
public class SendFileEmail {


    @Test()
    public static void sendReportTest() throws IOException {

        send(Jsoup.parse(new File("finalReport.html"), "UTF-8").html());
    }


    public static void send(String html) {

        String recipient = "pmarakko@cisco.com";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");


        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("abarabascisco@gmail.com", "jasper2006");//change accordingly
                    }
                });

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("abarabascisco@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.addRecipient(Message.RecipientType.CC, new InternetAddress("abarabas@cisco.com"));
            message.setSubject("Consolidated Progress Report");
            message.setContent(html, "text/html");
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}

