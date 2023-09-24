package com.example.demoAPI.controller;

import com.example.demoAPI.model.Cocktail;
import com.example.demoAPI.model.Coffee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CocktailController {
    @GetMapping(value = "/cocktail")
    public Cocktail cocktail (@RequestParam(value="name",defaultValue="mojito") String name){
        return new Cocktail(1, name);
    }
}
