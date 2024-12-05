package com.pluralsight.beanDemo;

import org.springframework.stereotype.Component;

@Component
public class MessageService {
    private String message;

    public MessageService(String m) {
        this.message = m;
    }

    public String getMessage() {
        return this.message;
    }
}
