package com.pluralsight.beanDemo;

import org.springframework.stereotype.Component;

@Component
public class Barista {

    private CoffeeBean coffeeBean;

    public Barista(CoffeeBean coffeeBean) {
        this.coffeeBean = coffeeBean;
    }

    public String prepareCoffee() {
        return "Preparing coffee: " + coffeeBean.getCoffeeType();
    }
}
