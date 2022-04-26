package com.example.today_is_diary.post.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PostDto {
    private Integer id;

    private String title;

    private String content;

}
