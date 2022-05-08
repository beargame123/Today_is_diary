package com.example.today_is_diary.good;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class GoodDto {
    @NotNull
    private int postId;

    @NotNull
    private int commentId;
}
