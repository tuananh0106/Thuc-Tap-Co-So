package com.example.demo_forum_web.controllers;

import com.example.demo_forum_web.entities.User;
import com.example.demo_forum_web.reponsitories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Objects;

@Controller
public class RegisterController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterController(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @GetMapping("register")
    public String displayRegister(Model model){
        return"register";
    }
    @PostMapping("register")
    public RedirectView registerUser(@RequestParam("username") String username,
                                     @RequestParam("password") String password,
                                     @RequestParam("introduction") String introduction,
                                     HttpServletRequest request){
        String contextPath=request.getContextPath();
        User user =new User();
        if(userRepository.getUserByUsername(username)==null){
            user.setUsername(username);
            if(Objects.equals(introduction,"")){
                user.setIntroduction(null);
            }
            else
                user.setIntroduction(introduction);
            user.setPassword(password);
            user.setPassword(passwordEncoder.encode(password));
            user.setCreate_date(LocalDateTime.now());
            userRepository.save(user);
            return new RedirectView(contextPath+"/login");
        }
        else{
            return new RedirectView(contextPath+"/register");
        }
    }
}
