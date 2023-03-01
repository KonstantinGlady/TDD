package org.example.mailserver;

public class MockMailServer implements MailServer {
     boolean wasCalled;
     String text;
     String recipient;
     String subject;

    @Override
    public void sendEmail(String recipient, String subject, String text) {
        this.wasCalled = true;
        this.recipient = recipient;
        this.subject = subject;
        this.text = text;
    }
}
