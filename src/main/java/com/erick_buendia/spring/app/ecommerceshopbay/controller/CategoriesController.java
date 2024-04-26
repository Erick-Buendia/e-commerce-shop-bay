package com.erick_buendia.spring.app.ecommerceshopbay.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erick_buendia.spring.app.ecommerceshopbay.entity.Categories;
import com.erick_buendia.spring.app.ecommerceshopbay.service.CategoriesService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    @Autowired
    CategoriesService categoriesService;

    @GetMapping()
    public List<Categories> findAllCategories() {
        return categoriesService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Categories> findByIdCategory(@PathVariable Long id) {
        return categoriesService.findById(id);
    }

    @PostMapping()
    public ResponseEntity<?> saveCategories(@RequestBody Categories categories) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriesService.save(categories));
    }

    @PutMapping("/{id}")
    public Optional<Categories> updateCategory(@PathVariable Long id, @RequestBody Categories categories) {
        return categoriesService.update(id, categories);
    }

    @DeleteMapping("/{id}")
    Optional<Categories> deleteCategory(@PathVariable Long id) {
        return categoriesService.delete(id);
    }

}
