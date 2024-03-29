package com.robson.webservices_spring.resources;

import com.robson.webservices_spring.entities.User;
import com.robson.webservices_spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj); // Resposta 201
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build(); // resposta 204
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj ){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj); // resposta 200
    }
}

