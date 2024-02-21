package com.testprojects.controller;

import com.testprojects.entity.Post;
import com.testprojects.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
      private PostService postService;

    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
        return  postService.getAllPosts(userId);
    }
    @GetMapping("/{postId}")
        public Post getOnePost(@PathVariable Long postId){
            return postService.getOnePostById(postId);
        }



}
