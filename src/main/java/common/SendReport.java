package common;

import org.openqa.selenium.devtools.Message;
import org.openqa.selenium.devtools.v123.target.model.SessionID;

import java.io.File;
import java.net.PasswordAuthentication;
import java.util.Arrays;
import java.util.Properties;

public class SendReport {

    public static File getNewReport(String testReport){
        File[] files = new File(testReport).listFiles();
        Arrays.sort(files,(a,b) -> Long.compare(b.lastModified(),a.lastModified()));
        return files[0];
    }

    public static void sendMail(File fileNew){
        final String username = "egd_automation@outlook.com";
        final String password = "Tims@123";
        String from = "egd_automation@outlook.com";
        String[] to = {"ysun@ecogaragedoors.com.au", "margarita.plusch@gmail.com", "Keyvan.Aghaie@gmail.com"};
        String subjects = "UI Automation Report";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username,password);
            }
        });

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            for(String recipient : to){
                message.addRecipient(Message.RecipientType.To, new InternetAddress(recipient));
            }
            message.setSubject(subject);

            Multipart multipart = new MimeMultipart();

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("UI Automation Test Report automatically sends everyday at 18:15, DO NOT reply.You can check details from the attachment, thank you!");
            multipart.addBodyPart(messageBodyPart);

            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(fileNew);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName("UI_Automation_Test_Report for EGD Dev.html");
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Mail sent successfully.");
        } catch (MessagingException e) {
            System.out.println("Mail send error: " + e.getMessage());
        }
    }

//    public static void main(String[] args) {
//        String testDirUI = "C:\\Users\\Yi Sun\\PycharmProjects\\EGD\\UITestCase";
//        String testReportUI = "C:\\Users\\Yi Sun\\PycharmProjects\\EGD\\Report\\UI";
//
//        String now = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd_HH_mm_ss"));
//        String filename1 = testReportUI + "\\" + now + "_result.html";
//
//        // Perform tests and generate report
//        // ...
//
//        File newReport1 = getNewReportUI(testReportUI);
//        sendMailUI(newReport1);
//    }
}
