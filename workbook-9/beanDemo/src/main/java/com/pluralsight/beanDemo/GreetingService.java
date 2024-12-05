package com.pluralsight.beanDemo;

import org.springframework.stereotype.Component;

@Component
public class GreetingService {

    public String getGreeting() {
        return "Hello World!";
    }
}
