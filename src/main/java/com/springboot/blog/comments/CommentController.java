package com.springboot.blog.comments;

import com.springboot.blog.common.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/posts/{postId}/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    List<Comment> getAllCommentsForPostId(@PathVariable long postId){
        postIdValidation(postId);
        return commentService.getAllCommentsForPostId(postId);
    }

    @PostMapping
    Comment postNewComment(@RequestBody CommentDto commentDto, @PathVariable long postId){
        postIdValidation(postId);
        return commentService.newComment(commentDto, postId);
    }

    @PutMapping("/{id}")
    Comment updateComment(@RequestBody CommentDto commentDto,  @PathVariable long postId, @PathVariable long id){
        postIdValidation(postId);
        return commentService.updateComment(commentDto, id);
    }

    @DeleteMapping("/{id}")
    void deleteComment(@PathVariable long postId, @PathVariable long id){
        postIdValidation(postId);
        commentService.deleteComment(id);
    }

    private void postIdValidation(long postId) {
        if(!commentService.isPostExists(postId))
            throw new ResourceNotFoundException("Post with id "+ postId + " does not exists");
    }

}
