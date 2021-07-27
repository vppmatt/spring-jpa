package org.example.dipattern;

import org.example.dipattern.service.MessageService;

public class MiniOutlook {

    // what is the dependency that can be injected
    // emailService? SmsService?
    private MessageService service;


    // Instead of MyDIConsumer to call for dependency, they guy
    // instantiating MyDIConsumer should call for the exact dependency type.

    // Hollywood principle: 'Don't call us, we will call you'
    public MiniOutlook(MessageService service) {
        this.service = service;
    }

    public void processMessage(String msg, String rec){
        this.service.sendMessage(msg, rec);
    }
}
