package com.example.today_is_diary.post;

import com.example.today_is_diary.post.dto.PostDto;
import com.example.today_is_diary.post.dto.PostList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/see")
    public List<PostList> get(){
        return postService.postList();
    }

    @PostMapping("/create")
    public void create(@RequestBody PostDto postDto){
        postService.create(postDto);
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable int id){
        postService.delete(id);
    }

    @PutMapping("/put/{id}")
    public void put(@RequestBody PostDto postDto, @PathVariable int id){
        postService.setPost(postDto,id);
    }

}
