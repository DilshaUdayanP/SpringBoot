package com.example.Annotation.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// Class
public class Email {
    private String recipient;
    private String subject;
    public String getRecipient() { return recipient; }
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
}
