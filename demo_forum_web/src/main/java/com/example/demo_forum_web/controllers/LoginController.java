package com.example.demo_forum_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("login")
    public String displayLogin(){
        return "login";
    }
}
