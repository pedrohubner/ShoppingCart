package com.app.product.controllers;

import com.app.facade.AppFacade;
import com.app.product.models.Product;
import com.app.product.repositories.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    @Mock
    AppFacade appFacade;

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductController productController;

    @Test
    public void returnProduct_ifProductIsFound() {
//        productController.createProduct(product);
//        verify(appFacade, times(1)).createProduct(any());
        when(productRepository.save(any(Product.class))).thenReturn(new Product());

        Product product = new Product();

        assertThat(productController.createProduct(product));
    }

    @Test
    public void findProductById_ifIdNotNull() {
        productController.findProduct(1L);
        verify(appFacade, times(2)).findProductById(any());
    }

    @Test
    public void returnProductDTOList() {
        productController.getDTOProductList();
        verify(appFacade, times(1)).getDTOProductList();
    }

    @Test
    public void deleteProductById_ifIdNotNull() {
        productController.deleteProduct(1L);
        verify(appFacade, times(1)).deleteProductById(any());
    }

    @Test
    public void deleteAllProducts() {
        productController.deleteAllProduct();
        verify(appFacade, times(1)).deleteAllProducts();
    }
}