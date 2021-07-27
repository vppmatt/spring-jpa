package org.example.springinjection;

import org.example.springinjection.configuration.AppConfig;
import org.example.springinjection.consumer.MySpringDiConsumer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // context is where spring holds all data regarding your beans, dependencies, components etc..
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MySpringDiConsumer consumer = context.getBean(MySpringDiConsumer.class);
        consumer.processMessage("Hi Hatef", "hatef@abc.com");

        context.close();
    }
}
