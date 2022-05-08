package com.example.today_is_diary.good.comments;

import com.example.today_is_diary.comment.Comment;
import com.example.today_is_diary.comment.CommentRepository;
import com.example.today_is_diary.good.Good;
import com.example.today_is_diary.good.posts.GoodRepository;
import com.example.today_is_diary.user.User;
import com.example.today_is_diary.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentGoodService {
    private final CommentRepository commentRepository;
    private final GoodRepository goodRepository;
    private final UserRepository userRepository;

    private boolean likeOrNot(User user, Comment comment){
        return goodRepository.findByUserAndComment(user,comment).isEmpty();
    }

    //좋아요 여부
    public void insert(int postId){
        Comment comment = commentRepository.findById(postId).orElseThrow(()-> new IllegalArgumentException("not found"));
        User user = userRepository.findById(postId).orElseThrow(()-> new IllegalArgumentException("not found"));
        Good good = new Good(comment, user);

        if(likeOrNot(good.getUser(), comment)){
            goodRepository.save(good);
        }
        else{
            throw new RuntimeException();
        }
    }
}
