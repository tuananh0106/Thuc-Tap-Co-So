package com.example.forum_web_ver_2.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ProfileController {
    @GetMapping("/profile")
    public String showprofile(){
        return "/profile";
    }
}
