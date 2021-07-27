package org.example.springinjection.service;

public class TwitterServiceImpl implements MessageService{
    @Override
    public boolean sendMessage(String msg, String rec) {
        System.out.println("Twitter message sent to " + rec + " with message " + msg);
        return true;
    }
}
