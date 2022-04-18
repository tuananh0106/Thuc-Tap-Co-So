package com.example.demo_forum_web.reponsitories;

import com.example.demo_forum_web.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicReponsitory extends JpaRepository<Topic,Long> {
}
