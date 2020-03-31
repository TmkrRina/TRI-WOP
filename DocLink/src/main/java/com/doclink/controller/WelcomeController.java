package com.doclink.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String welcomeDoclinkUser() {
        return "User added succesfully...";
    }

}
