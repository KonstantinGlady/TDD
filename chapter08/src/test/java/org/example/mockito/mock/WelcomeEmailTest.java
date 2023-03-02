package org.example.mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WelcomeEmailTest {


    private  EmailServer emailServer;

    @Test
    void sendWelcomeEmail() {

        var notifications = new UserNotifications(emailServer);
        notifications.welcomeNewUser("example@example.com");

    }
}
