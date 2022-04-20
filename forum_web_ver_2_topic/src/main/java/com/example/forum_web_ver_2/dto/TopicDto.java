package com.example.forum_web_ver_2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicDto {
    private String title;
    private String CreationDate;
    private String Body;
}
