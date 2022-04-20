package com.example.forum_web_ver_2.controller;

import com.example.forum_web_ver_2.dto.TopicDto;
import com.example.forum_web_ver_2.service.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewTopicController {
    private TopicService topicService;
    @ModelAttribute("topic")
    public TopicDto topicDto(){
        return new TopicDto();
    }
    @GetMapping("/newtopic")
    public String showNewTopic(){
        return "/newtopic";
    }
    @PostMapping("/newtopic")
    public String getnewTopic(Model model){
        return null;
    }
}
