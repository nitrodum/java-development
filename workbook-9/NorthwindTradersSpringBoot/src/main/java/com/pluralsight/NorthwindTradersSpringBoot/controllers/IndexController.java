package com.pluralsight.NorthwindTradersSpringBoot.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {

    @GetMapping
    public String index(@RequestParam( defaultValue = "World") String country) {
        return "Hello " + country + "!";
    }
}
