package com.thiagoabreu.workshopmongo.services;

import com.thiagoabreu.workshopmongo.domain.Post;
import com.thiagoabreu.workshopmongo.repository.PostRepository;
import com.thiagoabreu.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Post not found"));
    }

    public List<Post> findByTitle(String text){
        return repository.searchTitle(text);
    }
}
