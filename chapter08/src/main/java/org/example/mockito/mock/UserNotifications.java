package org.example.mockito.mock;

public class UserNotifications {
    private final MailServer mailServer;

    public UserNotifications(MailServer mailServer) {

        this.mailServer = mailServer;
    }

    public void welcomeNewUser(String recipient) {
        mailServer.sendEmail(recipient,
                "Welcome!",
                "Welcome to account");
    }
}
