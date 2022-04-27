package com.example.today_is_diary.comment;

import com.example.today_is_diary.comment.dto.CommentDto;
import com.example.today_is_diary.comment.dto.CommentList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/List/{postId}")
    public List<CommentList> see(@PathVariable int postId){
        return commentService.commentList(postId);
    }

    @PostMapping("/{postId}")
    public void create(@PathVariable int postId, @RequestBody CommentDto commentDto){
        commentService.create(postId, commentDto);
    }

    @PutMapping("/{chatId}")
    public void set(@PathVariable int chatId, @RequestBody CommentDto commentDto){
        commentService.set(chatId, commentDto);
    }

    @DeleteMapping("/{chatId}")
    public void delete(@PathVariable int chatId){
        commentService.del(chatId);
    }

}
