package com.thiagoabreu.workshopmongo.services;

import com.thiagoabreu.workshopmongo.domain.User;
import com.thiagoabreu.workshopmongo.repository.UserRepository;
import com.thiagoabreu.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

}
