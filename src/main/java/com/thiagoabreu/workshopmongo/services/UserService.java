package com.thiagoabreu.workshopmongo.services;

import com.thiagoabreu.workshopmongo.domain.User;
import com.thiagoabreu.workshopmongo.dto.UserDTO;
import com.thiagoabreu.workshopmongo.repository.UserRepository;
import com.thiagoabreu.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public User insert(User obj){
        return repository.insert(obj);
    }

    public void deleteById(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User update(User obj) {
        User user = findById(obj.getId());
        if (obj.getName() != null){
            user.setName(obj.getName());
        }
        if (obj.getEmail() != null){
            user.setEmail(obj.getEmail());
        }
        return repository.save(user);
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

}
