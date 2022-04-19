package com.example.forum_web_ver_2.service.Impl;

import com.example.forum_web_ver_2.dto.UserDto;
import com.example.forum_web_ver_2.entity.User;
import com.example.forum_web_ver_2.reponsitory.UserReponsitory;
import com.example.forum_web_ver_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserReponsitory userReponsitory;
    @Override
    public void save(UserDto userDto) {
        User user=new User(userDto.getEmail(),
                userDto.getUserDisplayName(),
                ".",
                0,
                0,
                userDto.getPassword(),
                "8/4/2022",
                "ROLE_USER"
        );
        System.out.println(user);
        userReponsitory.save(user);
    }

    @Override
    public Boolean checkPasswordUser(String email,String password) {
        User user = userReponsitory.findUserByEmail(email);
        if(user.getPassword().equals(password)) return true;
        return false;
    }
}
