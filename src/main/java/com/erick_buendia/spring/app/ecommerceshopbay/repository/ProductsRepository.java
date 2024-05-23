package com.erick_buendia.spring.app.ecommerceshopbay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.erick_buendia.spring.app.ecommerceshopbay.entity.Products;

public interface ProductsRepository extends CrudRepository<Products, Long> {

    @Query("SELECT p FROM Products p WHERE p.id=?1")
    Optional<Products> findByProductsId(Long id);
}
