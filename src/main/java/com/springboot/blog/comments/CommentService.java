package com.springboot.blog.comments;

import com.springboot.blog.common.*;
import com.springboot.blog.posts.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public CommentService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    boolean isPostExists(long id){
        return postRepository.findById(id).isPresent();
    }

    List<Comment> getAllCommentsForPostId(long id){
        return commentRepository.findByPostId(id);
    }

    Comment getCommentById(long id){
        return commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment with id "+ id +" is not found in DB"));
    }

    Comment newComment(CommentDto comment, long postId){
        Comment entity = new Comment(comment.getComment(), postId);
        entity.setPost(new Post(postId));
        return commentRepository.save(entity);
    }

    Comment updateComment(CommentDto comment, long id){
        Comment entity = getCommentById(id);
        entity.setComment(comment.getComment());
        return commentRepository.save(entity);
    }

    void deleteComment(long id){
        commentRepository.delete(getCommentById(id));
    }

}
