package com.robson.webservices_spring.resources;

import com.robson.webservices_spring.entities.Category;
import com.robson.webservices_spring.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories") // Cria o End Point para a classe
public class CategoryResources {
    @Autowired // Injeção de dependencia
    private CategoryService service;

    @GetMapping() //Tipo de requisição
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") // Tipo de requisição com parametro passado pelo end poind
    public ResponseEntity<Category> findById(@PathVariable Long id){ // A anotação @PathVariable permite pegar o parametro passado no End Point
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}

