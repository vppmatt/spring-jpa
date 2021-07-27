package org.example.dipattern.service;

import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements MessageService{

    @Override
    public void sendMessage(String msg, String rec) {
        System.out.println("Email sent to " + rec + " with message " + msg);
    }
}
