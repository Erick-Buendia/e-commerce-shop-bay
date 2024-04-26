package com.erick_buendia.spring.app.ecommerceshopbay.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick_buendia.spring.app.ecommerceshopbay.entity.Categories;
import com.erick_buendia.spring.app.ecommerceshopbay.repository.CategoriesRespository;

@Service
public class CategoriesServerImpl implements CategoriesService {

    @Autowired
    CategoriesRespository categoriesRespository;

    @Override
    public List<Categories> findAll() {
        return (List<Categories>) categoriesRespository.findAll();
    }

    @Override
    public Optional<Categories> findById(Long id) {
        return categoriesRespository.findById(id);
    }

    @Override
    public Categories save(Categories categories) {
        return categoriesRespository.save(categories);
    }
    
    @Override
    public Optional<Categories> update(Long id, Categories categories) {
        Optional<Categories> categoryOptional = categoriesRespository.findById(id);
        categoryOptional.ifPresent(category->{
            category.setName(categories.getName());
            category.setDescription(categories.getDescription());
            categoriesRespository.save(category);
        });
        return categoryOptional;
    }

    @Override
    public Optional<Categories> delete(Long id) {
        Optional<Categories> categoryOptional = categoriesRespository.findById(id);
        if (categoryOptional.isPresent()) {
            categoriesRespository.delete(categoryOptional.orElseThrow());
        }
        return categoryOptional;
    }


}
