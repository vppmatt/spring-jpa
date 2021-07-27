package org.example.practice;

import org.springframework.stereotype.Component;

@Component
public class MyBean {
    private String name;

    public void sayHello(){
        System.out.println("Hello " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
