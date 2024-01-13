package com.robson.webservices_spring.services;

import com.robson.webservices_spring.model.entities.User;
import com.robson.webservices_spring.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
    public User findById(Long id){
        Optional<User> user = repository.findById(id);
        return user.get();
    }
}
