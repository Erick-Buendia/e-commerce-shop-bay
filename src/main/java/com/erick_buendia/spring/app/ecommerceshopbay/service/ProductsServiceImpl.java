package com.erick_buendia.spring.app.ecommerceshopbay.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick_buendia.spring.app.ecommerceshopbay.entity.Categories;
import com.erick_buendia.spring.app.ecommerceshopbay.entity.Products;
import com.erick_buendia.spring.app.ecommerceshopbay.repository.CategoriesRespository;
import com.erick_buendia.spring.app.ecommerceshopbay.repository.ProductsRepository;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    CategoriesRespository categoriesRespository;

    @Override
    public List<Products> findAll() {
        return (List<Products>) productsRepository.findAll();
    }

    @Override
    public Optional<Products> findById(Long id) {
        return productsRepository.findById(id);
    }

    @Override
    public Products save(Products products) {
        Set<Categories> categories = new HashSet<>();
        products.getCategories().forEach(category -> {
            Optional<Categories> categoryOptional = categoriesRespository.findById(category.getId());
            categoryOptional.ifPresent(categoryBd -> {
                categories.add(categoryBd);
            });
        });
        products.setCategories(categories);
        return productsRepository.save(products);
    }

    @Override
    public Optional<Products> update(Long id, Products products) {
        Optional<Products> productOptional = productsRepository.findById(id);
        productOptional.ifPresent(product -> {
            product.setName(products.getName());
            product.setDescription(products.getDescription());
            product.setUpc(products.getUpc());
            product.setTrademark(products.getTrademark());
            product.setPrice(products.getPrice());
            product.setQuantity(products.getQuantity());
            productsRepository.save(product);
        });
        return productOptional;
    }

    @Override
    public Optional<Products> delete(Long id) {
        Optional<Products> productOptional = productsRepository.findById(id);
        productOptional.ifPresent(product -> {
            productsRepository.delete(product);
        });
        return productOptional;
    }

}
