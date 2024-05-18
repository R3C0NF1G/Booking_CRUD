package com.edu.unbosque.ch0ch4l1t0.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/","/open"})
    public String home(){

        return "open";
    }

}

