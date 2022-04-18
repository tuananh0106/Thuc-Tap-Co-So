package com.example.demo_forum_web.reponsitories;

import com.example.demo_forum_web.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByUsername(String username);
}
