package com.example.today_is_diary.post;

import com.example.today_is_diary.post.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/see")
    public void get(){
        postService.postList();
    }

    @PostMapping("/create")
    public void create(PostDto postDto){
        postService.create(postDto);
    }

    @DeleteMapping("/del/{id}")
    public void del(PostDto postDto, @PathVariable int id){
        postService.delete(id);
    }

    @PutMapping("/put/{id}")
    public void put(PostDto postDto, @PathVariable int id){
        postService.setPost(postDto,id);
    }

}
