package com.example.forum_web_ver_2.service;

import com.example.forum_web_ver_2.dto.TopicDto;
import com.example.forum_web_ver_2.entity.User;

public interface TopicService {
    void save(TopicDto topicDto, User user);
}
