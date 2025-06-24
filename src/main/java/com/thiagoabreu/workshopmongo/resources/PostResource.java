package com.thiagoabreu.workshopmongo.resources;

import com.thiagoabreu.workshopmongo.domain.Post;
import com.thiagoabreu.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post user = service.findById(id);
        return ResponseEntity.ok(user);

    }

}
