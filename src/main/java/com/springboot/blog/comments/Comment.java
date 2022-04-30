package com.springboot.blog.comments;

import com.fasterxml.jackson.annotation.*;
import com.springboot.blog.posts.*;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private Post post;

    private String comment;

    public Comment() {
    }

    public Comment(String comment, long postId) {
        this.comment = comment;
        this.post=new Post(postId);
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
