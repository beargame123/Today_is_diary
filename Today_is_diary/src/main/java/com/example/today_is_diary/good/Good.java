package com.example.today_is_diary.good;

import com.example.today_is_diary.comment.Comment;
import com.example.today_is_diary.post.Post;
import com.example.today_is_diary.user.User;
import lombok.*;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "GOOD")
public class Good {

    @EmbeddedId
    private GoodId id;

    @ManyToOne
    @MapsId("postId")
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Builder
    public Good(Post post, User user){
        this.user = user;
        this.post = post;
    }

    @Builder
    public Good(Comment comment, User user){
        this.comment = comment;
        this.user = user;
    }
}
