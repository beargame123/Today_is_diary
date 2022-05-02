package com.example.today_is_diary.good.posts;

import com.example.today_is_diary.comment.Comment;
import com.example.today_is_diary.good.Good;
import com.example.today_is_diary.good.GoodId;
import com.example.today_is_diary.post.Post;
import com.example.today_is_diary.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GoodRepository extends JpaRepository<Good, GoodId> {
    Optional<Good> findByUserAndPost(User user, Post post);
    Optional<Good> findByUserAndComment(User user, Comment comment);
}
