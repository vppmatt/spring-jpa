package org.example.manual;

public class MiniOutlook {
    // Here we inject an instance of emailService [dependency]
    EmailService emailService = new EmailService();

    public void processMessage(String msg, String rec){
        emailService.sendEmail(msg, rec);
    }
}
