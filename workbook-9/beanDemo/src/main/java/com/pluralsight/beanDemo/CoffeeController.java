package com.pluralsight.beanDemo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coffeeBeans")
public class CoffeeController {

    private Barista barista;
    private CoffeeShopService coffeeShopService;
    private CoffeeBean coffeeBean;

    public CoffeeController(Barista barista, CoffeeShopService service, CoffeeBean coffeeBean) {
        this.barista = barista;
        this.coffeeShopService = service;
        this.coffeeBean = coffeeBean;
    }

    @PostMapping("/order/{coffeeType}")
    public String order(@PathVariable String coffeeType) {
        coffeeBean.setCoffeeType(coffeeType);
        return coffeeShopService.takeOrder(coffeeType) + "\n" + barista.prepareCoffee() + "\nRandom ID: " + coffeeShopService.getRandom();
    }

    @GetMapping("/serve")
    public String serveOrder() {
        return coffeeShopService.serveOrder() + "\n" + coffeeBean.getCoffeeType() + "\nRandom ID: " + coffeeShopService.getRandom();
    }

}
