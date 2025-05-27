package com.omuny.web_Blog.repo;

import com.omuny.web_Blog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

}
