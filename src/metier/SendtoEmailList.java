
package metier;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author Yashiro
 */
public class SendtoEmailList {

    private static String USER_NAME = "f114524@gmail.com";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "QI9A5fve"; // GMail password
    private static String RECIPIENT = "fiLizlaetteEhyscamilla@hotmail.com";
    
    public SendtoEmailList(String email) {
        RECIPIENT=email;
        System.out.println("reach it!");
    }

    public static void main(String[] args) {
        String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = { RECIPIENT }; // list of recipient email addresses
        String subject = "Java send mail example";
        String body = "Welcome to JavaMail!"
                + "This is an reminder. Your payment has not been processed and your order will be canceled within 3 days if you do not contact us."
                + "Thank you for your patience and have a great day!";
        
        sendFromGMail(from, pass, to, subject, body);
    }

    public static boolean sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            return true;
        }
        catch (AddressException ae) {
            ae.printStackTrace();
            return false;
        }
        catch (MessagingException me) {
            me.printStackTrace();
            return false;
        }
    }
}