package com.example.today_is_diary.post;

import com.example.today_is_diary.post.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public void create(PostDto postDto){
        Post post = new Post(postDto.getContent(), postDto.getTitle());
        postRepository.save(post);
    }
}
