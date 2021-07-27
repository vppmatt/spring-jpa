package org.example.dipattern.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SmsServiceImpl implements MessageService{
    @Override
    public void sendMessage(String msg, String rec) {
        System.out.println("SMS sent to " + rec + " with message " + msg);
    }
}
