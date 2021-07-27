package org.example.springinjection.consumer;

import org.example.springinjection.service.MessageService;
import org.springframework.stereotype.Component;

@Component // tells context that this class can be a candidate for injection
public class MySpringDiConsumer {
    private MessageService messageService;

    public MySpringDiConsumer(MessageService messageService) {
        this.messageService = messageService;
    }
    
    public boolean processMessage(String message, String rec){
        return this.messageService.sendMessage(message, rec);
    }
}
