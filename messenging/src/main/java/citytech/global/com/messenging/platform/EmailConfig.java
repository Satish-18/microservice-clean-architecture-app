package citytech.global.com.messenging.platform;
import citytech.global.com.messenging.usecase.sendemail.EmailRequest;
import jakarta.inject.Inject;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public class EmailConfig {
    @Inject
    private EmailConfig() {
    }
    public static void sendMail(EmailRequest emailRequest,String password){
        try{
            MimeMessage mimeMessage = new MimeMessage(getSession(emailRequest.from(),password));
            mimeMessage.setFrom(emailRequest.from());
            mimeMessage.addRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(emailRequest.to())});
            mimeMessage.setSubject("Welcome to Sapatide");
            mimeMessage.setContent(emailRequest.htmlContent(),"text/html");
            Transport.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    private static Session getSession(String email,String password){
        Session session = Session.getInstance(getProperties(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(email,password);
            }
        });
        session.setDebug(true);
        return session;
    }
    private static Properties getProperties(){
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");
        return properties;
    }
}
