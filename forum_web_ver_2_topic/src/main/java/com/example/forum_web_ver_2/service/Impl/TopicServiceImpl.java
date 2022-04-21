package com.example.forum_web_ver_2.service.Impl;

import com.example.forum_web_ver_2.dto.TopicDto;
import com.example.forum_web_ver_2.entity.Topic;
import com.example.forum_web_ver_2.entity.User;
import com.example.forum_web_ver_2.reponsitory.TopicReponsitory;
import com.example.forum_web_ver_2.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicReponsitory topicReponsitory;
    @Override
    public void save(TopicDto topicDto, Integer UserId) {
        System.out.println("haha");
        Topic topic = new Topic(topicDto.getTitle(),
                "21/4/2022",
                topicDto.getBody(),
                UserId);
        System.out.println(topic);
        topicReponsitory.save(topic);
    }
}
