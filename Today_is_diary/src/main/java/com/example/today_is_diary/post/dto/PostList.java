package com.example.today_is_diary.post.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostList {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime dateTime;

    @Builder
    public PostList(Integer id, String title, String content, LocalDateTime dateTime){
        this.id = id;
        this.title = title;
        this.content = content;
        this.dateTime = dateTime;
    }
}
