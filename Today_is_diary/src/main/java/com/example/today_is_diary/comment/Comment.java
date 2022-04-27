package com.example.today_is_diary.comment;

import com.example.today_is_diary.post.Post;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "COMMENT")
@RequiredArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "comment")
    private String comment;

    @Column
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "PostId")
    private Post post;

    public Comment(String comment,Post post){
        this.comment = comment;
        this.post = post;
    }

    @PrePersist
    public void prepersist(){
        this.dateTime = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.dateTime = LocalDateTime.now();
    }
}
