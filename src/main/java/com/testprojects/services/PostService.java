package com.testprojects.services;

import com.testprojects.entity.Post;
import com.testprojects.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent()) {
            return postRepository.findByUserId(userId.get());

        }
        else
            return postRepository.findAll();

    }

    public Post getOnePostById(Long postId) {
        return  postRepository.findById(postId).orElse(null);
    }
}
