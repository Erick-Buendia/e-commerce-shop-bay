package com.erick_buendia.spring.app.ecommerceshopbay.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erick_buendia.spring.app.ecommerceshopbay.entity.Products;
import com.erick_buendia.spring.app.ecommerceshopbay.service.ProductsService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("api/products")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @GetMapping()
    public List<Products> findAllProducts() {
        return productsService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Products> findByIdProduct(@PathVariable Long id) {
        return productsService.findById(id);
    }

    @PostMapping()
    public Products saveProduct(@RequestBody Products products) {
        return productsService.save(products);
    }

    @PutMapping("/{id}")
    public  Optional<Products> updateProduct(@PathVariable Long id, @RequestBody Products products) {
        return productsService.update(id, products);
    }

    @DeleteMapping("/{id}")
    public Optional<Products> deleteProduct(@PathVariable Long id) {
        return productsService.delete(id);
        //   return ResponseEntity.ok(addressUsersService.delete(id));
    }
    
}
