package org.example.mailserver;

public class UserNotifications {

    private final MailServer mailServer;

    public UserNotifications(MailServer mailServer) {

        this.mailServer = mailServer;
    }

    public void welcomeNewUser() {
        mailServer.sendEmail("recipient@example.com", "Welcome!", "Welcome new user");
    }
}
