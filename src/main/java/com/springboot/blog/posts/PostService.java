package com.springboot.blog.posts;

import com.springboot.blog.common.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //Get all posts
    List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    //Find a post
    Post findPostById(long id){
        return postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post with id "+ id +" is not found in DB"));
    }

    //Create post
    Post createNewPost(Post post){
        return postRepository.save(post);
    }

    //Update Post
    Post updatePost(Post post, long id){
        Post entity = findPostById(id);
        entity.setContent(post.getContent());
        entity.setTitle(post.getTitle());
        return postRepository.save(entity);
    }

    //Delete a post
    void deletePost(long id){
        postRepository.delete(findPostById(id));
    }

}
