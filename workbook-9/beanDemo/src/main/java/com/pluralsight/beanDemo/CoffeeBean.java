package com.pluralsight.beanDemo;

import org.springframework.stereotype.Component;

@Component
public class CoffeeBean {
    private String coffeeType;

    public CoffeeBean() {

    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(String coffeeType) {
        this.coffeeType = coffeeType;
    }
}
