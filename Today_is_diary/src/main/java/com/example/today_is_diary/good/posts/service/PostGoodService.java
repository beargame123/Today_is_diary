package com.example.today_is_diary.good.posts.service;

import com.example.today_is_diary.good.Good;
import com.example.today_is_diary.good.posts.GoodRepository;
import com.example.today_is_diary.post.Post;
import com.example.today_is_diary.post.PostRepository;
import com.example.today_is_diary.user.User;
import com.example.today_is_diary.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class PostGoodService {
    private final GoodRepository goodRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    private boolean likeOrNot(User user, Post post){
        return goodRepository.findByUserAndPost(user,post).isEmpty();
    }

    //좋아요 여부
    public void insert(int postId){
        Post post = postRepository.findById(postId).orElseThrow(()-> new IllegalArgumentException("not found"));
        User user = userRepository.findById(postId).orElseThrow(()-> new IllegalArgumentException("not found"));
        Good good = new Good(post, user);

        if(likeOrNot(good.getUser(), post)){
            goodRepository.save(good);
        }
        else{
            throw new RuntimeException();
        }
    }

}
