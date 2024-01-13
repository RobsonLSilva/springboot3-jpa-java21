package com.robson.webservices_spring.resources;

import com.robson.webservices_spring.model.entities.User;
import com.robson.webservices_spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users") // Cria o End Point para a classe
public class UserResources {
    @Autowired // Injeção de dependencia
    private UserService service;

    @GetMapping() //Tipo de requisição
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") // Tipo de requisição com parametro passado pelo end poind
    public ResponseEntity<User> findById(@PathVariable Long id){ // A anotação @PathVariable permite pegar o parametro passado no End Point
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}

