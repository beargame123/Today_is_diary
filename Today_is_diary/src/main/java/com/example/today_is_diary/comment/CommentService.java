package com.example.today_is_diary.comment;

import com.example.today_is_diary.comment.dto.CommentDto;
import com.example.today_is_diary.comment.dto.CommentList;
import com.example.today_is_diary.post.Post;
import com.example.today_is_diary.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public void create(int id,CommentDto dto){
        Post post = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found"));
        Comment comment = new Comment(dto.getComment(), post);
        commentRepository.save(comment);
    }

    public void del(int id){
        commentRepository.deleteById(id);
    }

    @Transactional
    public void set(int id, CommentDto dto){
        Comment comment = commentRepository.getById(id);
        comment.setComment(dto.getComment());
        commentRepository.save(comment);
    }

    @Transactional
    public List<CommentList> commentList(int id){
        Post post = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found"));
        List<Comment> comments = commentRepository.findAll();
        List<CommentList> commentLists = new ArrayList<>();

        for(Comment comment : comments){
            if(comment.getPost().getId().equals(post.getId())) {

                CommentList commentList = CommentList.builder()
                        .id(comment.getId())
                        .comment(comment.getComment())
                        .dateTime(comment.getDateTime())
                        .build();
                commentLists.add(commentList);
            }
        }
        return commentLists;
    }
}
