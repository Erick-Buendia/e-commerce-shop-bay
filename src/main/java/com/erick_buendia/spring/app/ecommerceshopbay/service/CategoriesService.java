package com.erick_buendia.spring.app.ecommerceshopbay.service;

import java.util.List;
import java.util.Optional;

import com.erick_buendia.spring.app.ecommerceshopbay.entity.Categories;

public interface CategoriesService {

    List<Categories> findAll();

    Optional<Categories> findById(Long id);

    Categories save(Categories categories);

    Optional<Categories> update(Long id, Categories categories);

    Optional<Categories> delete(Long id);

}
