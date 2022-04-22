package com.example.forum_web_ver_2.service.Impl;

import com.example.forum_web_ver_2.reponsitory.ProfileReponsitory;
import com.example.forum_web_ver_2.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileReponsitory profileReponsitory;
}
