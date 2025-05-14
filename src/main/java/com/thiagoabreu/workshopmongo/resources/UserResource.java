package com.thiagoabreu.workshopmongo.resources;

import com.thiagoabreu.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User thiago = new User("1", "Thiago Abreu", "thiago@gmail.com");
        User guilherme = new User("2", "Guilherme Linares", "guilherme@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(thiago, guilherme));

        return ResponseEntity.ok().body(list);
    }

}
