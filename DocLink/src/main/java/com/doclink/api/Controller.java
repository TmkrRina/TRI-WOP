package com.doclink.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String index() {
        return "{\"location\": \"homepage\", \"message\": \"Welcome\"}";
    }
}
