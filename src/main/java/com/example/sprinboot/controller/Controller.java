package com.example.sprinboot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring")
@CrossOrigin
public class Controller {
    @GetMapping()
    public String getMapping(){
        return "Get Mapping";
    }
}
