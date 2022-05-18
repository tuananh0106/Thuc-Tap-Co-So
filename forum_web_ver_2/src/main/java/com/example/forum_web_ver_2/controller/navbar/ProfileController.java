package com.example.forum_web_ver_2.controller.navbar;

import com.example.forum_web_ver_2.dto.ProfileDto;
import com.example.forum_web_ver_2.dto.UserDto;
import com.example.forum_web_ver_2.entity.Profile;
import com.example.forum_web_ver_2.entity.User;
import com.example.forum_web_ver_2.service.ProfileService;
import com.example.forum_web_ver_2.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@NoArgsConstructor
@AllArgsConstructor
@SessionAttributes("userdto")
public class ProfileController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProfileService profileService;

    @ModelAttribute("userdto")
    public UserDto userDto(){
        return new UserDto();
    }

    @ModelAttribute("profileuser")
    public ProfileDto profileDto(){
        return new ProfileDto();
    }
    @GetMapping("/profile")
    public String showprofile(@ModelAttribute("userdto")UserDto userDto, Model model){
        User user = userService.getUserbyEmail(userDto.getEmail());
        if(user ==null){
            return "redirect:/login";
        }
        model.addAttribute("user",user);
        Profile profile = profileService.findProfileByUser(user);
        model.addAttribute("profileuser",profile);
        return "profile";
    }

    @PostMapping("/profile")
    public String getprofile(@SessionAttribute("userdto")UserDto userDto, Model model,
                             @ModelAttribute("profileuser") ProfileDto profileDto){
        User user = userService.getUserbyEmail(userDto.getEmail());
        profileService.save(profileDto,user);
        return "profile";
    }
}
