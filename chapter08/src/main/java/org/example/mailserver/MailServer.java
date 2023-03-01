package org.example.mailserver;

public interface MailServer {
    void sendEmail(String recipient, String subject, String text);
}
