package com.springboot.blog.posts;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    Post getPostById(@PathVariable long id){
        return postService.findPostById(id);
    }

    @PostMapping
    Post createNewPost(@RequestBody Post post){
        return postService.createNewPost(post);
    }

    @PutMapping("/{id}")
    Post updatePost(@RequestBody Post post, @PathVariable long id){
        return postService.updatePost(post, id);
    }

    @DeleteMapping("/{id}")
    void deletePost(@PathVariable long id){
        postService.deletePost(id);
    }

}
