package org.example.springinjection.configuration;

import org.example.springinjection.service.EmailServiceImpl;
import org.example.springinjection.service.MessageService;
import org.example.springinjection.service.TwitterServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
// using this annotation spring knows where to look for its configs.
@ComponentScan(value = {"org.example.springinjection.consumer"})
public class AppConfig {

    // This method replaces the EmailServiceInjector that we had in DI pattern package
    @Bean
    public MessageService getMessageService(){
        return new TwitterServiceImpl();
    }
}
