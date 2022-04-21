package com.example.forum_web_ver_2.service;

import com.example.forum_web_ver_2.dto.TopicDto;
import com.example.forum_web_ver_2.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface TopicService {
    void save(TopicDto topicDto, Integer UserId);
}
