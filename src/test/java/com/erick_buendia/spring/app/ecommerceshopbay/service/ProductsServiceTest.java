package com.erick_buendia.spring.app.ecommerceshopbay.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.erick_buendia.spring.app.ecommerceshopbay.entity.Products;
import com.erick_buendia.spring.app.ecommerceshopbay.repository.CategoriesRespository;
import com.erick_buendia.spring.app.ecommerceshopbay.repository.ProductsRepository;

@SpringBootTest
public class ProductsServiceTest {

    private ProductsRepository productsRepository;
    private CategoriesRespository categoriesRespository;

    private ProductsService productsService;

  

    @BeforeEach
    void setUp() {
        productsRepository = mock(ProductsRepository.class);
        categoriesRespository = mock(CategoriesRespository.class);
        productsService = new ProductsServiceImpl();
    }



    @Test
    @DisplayName("Obtenemos una lista de productos")
    void testFindAll() {
        List<Products> products = productsService.findAll();
        assertEquals(products, List.class);
    }

    @Test
    void testFindById() {

    }

    @Test
    void testSave() {

    }

    @Test
    void testUpdate() {

    }

    @Test
    void testDelete() {

    }

}
