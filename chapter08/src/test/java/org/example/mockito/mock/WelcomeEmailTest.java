package org.example.mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class WelcomeEmailTest {

    @Mock
    private MailServer mailServer;

    @Test
    void sendWelcomeEmail() {

        var notifications = new UserNotifications(mailServer);
        notifications.welcomeNewUser("example@example.com");
        verify(mailServer).sendEmail("example@example.com",
                "Welcome!",
                "Welcome to account");
    }

    @Test
    void rejectInvalidEmailRecipient() {

        doThrow(new IllegalArgumentException())
                .when(mailServer).sendEmail(any(), any(), any());

        var notifications = new UserNotifications(mailServer);
        assertThatExceptionOfType(NotificationFailureException.class)
                .isThrownBy(() -> notifications.welcomeNewUser("not-an-email"));
    }
}
