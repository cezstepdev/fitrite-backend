package com.fitrite.api.security.email;

public interface EmailSender {
    void send(String to, String email);
}
