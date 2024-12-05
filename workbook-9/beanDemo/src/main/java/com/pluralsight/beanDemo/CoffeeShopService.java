package com.pluralsight.beanDemo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Scope("prototype")
public class CoffeeShopService {
    private int random = new Random().nextInt(1000);

    public int getRandom() {
        return random;
    }


    public String takeOrder(String coffeeType) {
        return "Order received for: " + coffeeType;
    }

    public String serveOrder() {
        return "Order served!";
    }
}
