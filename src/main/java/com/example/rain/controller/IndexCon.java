package com.example.rain.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexCon {



    @GetMapping("/index")
    public String index(){

        return "index";
    }
}
