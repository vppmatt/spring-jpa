package org.example.dipattern;

import org.example.dipattern.injector.EmailServiceInjector;
import org.example.dipattern.injector.MessageServiceInjector;
import org.example.dipattern.injector.SmsServiceInjector;

public class App {

    public static void main(String[] args) {
        // we should not create MyDiConsumer ourselves
        MessageServiceInjector injector;

        // send email
        injector = new EmailServiceInjector();
        // When we call getConsumer() using injector,
        // all the dependencies are already provided
        MiniOutlook consumer = injector.getConsumer();
        consumer.processMessage("Hi Hatef", "hatef@abc.com");


        // send sms
        injector = new SmsServiceInjector();
        consumer = injector.getConsumer();
        consumer.processMessage("Hi Hatef", "7823647624");
    }
}
