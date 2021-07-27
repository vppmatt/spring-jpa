package org.example.practice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        MyBean myBean = context.getBean(MyBean.class);
        myBean.setName("our new app");
        myBean.sayHello();

        context.close();
    }
}
