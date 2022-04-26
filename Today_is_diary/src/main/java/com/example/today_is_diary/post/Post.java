package com.example.today_is_diary.post;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
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
    private LocalDateTime date;

    public Post(String title, String content){
        this.title = title;
        this.content = content;
    }

    @PrePersist
    public void prepersist(){
        this.date = LocalDateTime.now();
    }
}
