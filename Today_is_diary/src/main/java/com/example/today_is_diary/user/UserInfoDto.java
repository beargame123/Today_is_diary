package com.example.today_is_diary.user;

import lombok.Data;

@Data
public class UserInfoDto {
    private  String email;
    private  String password;

    private  String auth;
}
