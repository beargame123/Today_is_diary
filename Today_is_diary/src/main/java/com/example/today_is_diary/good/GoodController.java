package com.example.today_is_diary.good;

import com.example.today_is_diary.good.comments.CommentGoodService;
import com.example.today_is_diary.good.posts.service.PostGoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;

@RestController
@RequiredArgsConstructor
public class GoodController {

    private final CommentGoodService commentGoodService;
    private final PostGoodService postGoodService;

    @PostMapping("/chat/like")
    public void insertComment(@RequestBody GoodDto goodDto){
        commentGoodService.insert(goodDto.getCommentId());
    }

    @PostMapping("/post/like")
    public void insertPost(@RequestBody GoodDto goodDto){
        postGoodService.insert(goodDto.getPostId());
    }

    /*@DeleteMapping("post/like/{postId}")
    public void deleteGood(@PathVariable String postId){
        postGoodService.deleteGood(postId);
    } 코딩해야함*/

    /*@DeleteMapping("chat/like/{chatId}")
    public void deleteGood(@PathVariable String chatId){
        commentGoodService.deleteGood(chatId);
    } 이것도 마찬가지로 코딩 해야함*/
}
