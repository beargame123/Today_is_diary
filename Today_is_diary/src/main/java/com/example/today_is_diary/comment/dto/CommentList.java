package com.example.today_is_diary.comment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class CommentList {
    private Integer id;
    private String comment;
    private LocalDateTime dateTime;

    @Builder
    public CommentList(Integer id, String comment, LocalDateTime dateTime){
        this.id = id;
        this.comment = comment;
        this.dateTime = dateTime;
    }
}
