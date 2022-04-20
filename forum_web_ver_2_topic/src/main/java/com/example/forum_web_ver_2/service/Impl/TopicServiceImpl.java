package com.example.forum_web_ver_2.service.Impl;

import com.example.forum_web_ver_2.dto.TopicDto;
import com.example.forum_web_ver_2.entity.Topic;
import com.example.forum_web_ver_2.entity.User;
import com.example.forum_web_ver_2.reponsitory.TopicReponsitory;
import com.example.forum_web_ver_2.service.TopicService;

public class TopicServiceImpl implements TopicService {
    private TopicReponsitory topicReponsitory;
    @Override
    public void save(TopicDto topicDto, User user) {
        Topic topic = new Topic(topicDto.getTitle(),
                topicDto.getCreationDate(),
                topicDto.getBody(),
                user);
        topicReponsitory.save(topic);
    }
}
