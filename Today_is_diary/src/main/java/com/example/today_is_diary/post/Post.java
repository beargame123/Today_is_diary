package com.example.today_is_diary.post;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Table(name = "POST")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "date")
    private Date date;
}
