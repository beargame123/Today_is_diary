package com.example.today_is_diary.post;

import com.example.today_is_diary.post.dto.PostDto;
import com.example.today_is_diary.post.dto.PostList;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public void create(PostDto postDto){
        Post post = new Post(postDto.getContent(), postDto.getTitle());
        postRepository.save(post);
    }

    @Transactional
    public List<PostList> postList(){
        Sort sort = Sort.by(Sort.Direction.ASC, "date");
        List<Post> posts =postRepository.findAll(sort);
        List<PostList> postLists = new ArrayList<>();

        for(Post post : posts){
            PostList dto = PostList.builder()
                    .title(post.getTitle())
                    .content(post.getContent())
                    .id(post.getId())
                    .dateTime(post.getDate())
                    .build();
            postLists.add(dto);
        }
        return postLists;
    }

    public void delete(int id){
        postRepository.deleteById(id);
    }

    @Transactional
    public void setPost(PostDto postDto, int id){
        Post post = postRepository.getById(id);
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDate(LocalDateTime.now());
        postRepository.save(post);
    }

}
