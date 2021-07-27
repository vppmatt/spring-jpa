package org.example.dipattern.service;

// we write this interface since we want to have different messageServices like EmailService and SmsService
public interface MessageService {
    void sendMessage(String msg, String rec);
}
