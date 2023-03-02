package org.example.mockito.mock;

public class UserNotifications {
    private final EmailServer emailServer;

    public UserNotifications(EmailServer emailServer) {

        this.emailServer = emailServer;
    }

    public void welcomeNewUser(String recipient) {
        emailServer.sendEmail(recipient,
                "Welcome!",
                "Welcome to account");
    }
}
