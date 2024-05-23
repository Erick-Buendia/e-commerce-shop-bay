package com.erick_buendia.spring.app.ecommerceshopbay.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.erick_buendia.spring.app.ecommerceshopbay.entity.Products;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductsRepositoryTest {

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    void testFindByProductsIdCaseFound() {
        Optional<Products> products = productsRepository.findByProductsId(1L);
        assertEquals(products.get().getName(), "Audifonos Bluetooth Jbl Vibe");
    }

    @Test
    void testFindByProductsIdCaseNotFound() {
        Optional<Products> products = productsRepository.findByProductsId(0L);
        assertEquals(products, Optional.empty());
    }
}
