package com.example.today_is_diary.user.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class UserDto {
    private Integer id;

    @NotBlank(message = "닉네임은 필수 입력칸입니다.")
    private String nickname;

    @NotBlank(message = "이메일은 필수 입력칸입니다.")
    @Email
    private String email;

    @NotBlank(message = "비밀번호는 필수 입력칸입니다.")
    @Pattern(regexp="(?=.*[0-9])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
    private String password;
}
