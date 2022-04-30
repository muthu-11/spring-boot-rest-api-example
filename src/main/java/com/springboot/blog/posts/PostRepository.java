package com.springboot.blog.posts;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
