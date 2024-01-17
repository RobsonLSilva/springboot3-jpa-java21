package com.robson.webservices_spring.services;

import com.robson.webservices_spring.entities.User;
import com.robson.webservices_spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
    public User save(User obj){
       return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
