package com.example.forum_web_ver_2.controller;

import com.example.forum_web_ver_2.service.TopicService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class TopicController {
    private TopicService topicService;
    @GetMapping("/topic/{id}")
    public String showTopicById(){
        return "topic";
    }
}
