package com.erick_buendia.spring.app.ecommerceshopbay.service;

import java.util.List;
import java.util.Optional;

import com.erick_buendia.spring.app.ecommerceshopbay.entity.Products;

public interface ProductsService {

    List<Products> findAll();

    Optional<Products> findById(Long id);

    Products save(Products products);

    Optional<Products> update(Long id, Products products);

    Optional<Products> delete(Long id);

}
