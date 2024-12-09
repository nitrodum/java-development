package com.pluralsight.NorthwindTradersSpringBoot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping(path="/", method = RequestMethod.GET)
    public String index(@RequestParam( defaultValue = "World") String country) {
        return "Hello " + country + "!";
    }
}
