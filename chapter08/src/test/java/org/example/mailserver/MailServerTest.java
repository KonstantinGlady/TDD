package org.example.mailserver;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class MailServerTest {

    @Test
    void sendWelcomeMessage() {
        var mailServer = new MockMailServer();
        var notifications = new UserNotifications(mailServer);
        notifications.welcomeNewUser();
        assertThat(mailServer.wasCalled).isTrue();
        assertThat(mailServer.recipient).isEqualTo("recipient@example.com");
        assertThat(mailServer.subject).isEqualTo("Welcome!");
        assertThat(mailServer.text).contains("Welcome new user");
    }
}
