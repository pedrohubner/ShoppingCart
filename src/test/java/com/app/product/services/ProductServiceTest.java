package com.app.product.services;

import com.app.product.models.Product;
import com.app.product.repositories.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    Product product;

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    public void createProduct_ifItExist() {
        productService.createProduct(product);
        verify(productRepository, times(1)).save(any());
    }

    @Test
    public void findProductById_IfIdNotNull() {
        productService.findProductById(1L);
        verify(productRepository, times(1)).findAllById(any());
    }

    @Test
    public void deleteProductById_ifIdNotNull() {
        productService.deletingProduct(product.getId());
        verify(productRepository, times(1)).deleteById(any());
    }

    @Test
    public void deleteAllProducts() {
        productService.deleteAllProducts();
        verify(productRepository, times(1)).deleteAllInBatch();
    }
}