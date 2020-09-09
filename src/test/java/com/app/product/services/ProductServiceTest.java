package com.app.product.services;

import com.app.exceptionhandler.ApiException;
import com.app.product.models.Product;
import com.app.product.repositories.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    public void mustReturnNewProductWhenRepositorySavesProduct() {
        Product product = new Product();
        when(productRepository.save(product)).thenReturn(product);
        Product product1 = productService.savingProductInMemory(product);
        Assert.assertEquals(product, product1);
    }

    @Test
    public void mustReturnAProductWhenItReturnsFullOptional() {
        Product product = new Product();
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        Product product1 = productService.findProductById(1L);
        Assert.assertEquals(product, product1);
    }

    @Test(expected = ApiException.class)
    public void mustThrowAnExceptionWhenItReturnsAnEmptyOptional() {
        when(productRepository.findById(1L)).thenReturn(Optional.empty());
        productService.findProductById(1L);
    }

    @Test
    public void decreaseProductInventoryIfInventoryIsBiggerThan_Zero(){
        Product product = new Product(1L, "Eno", 1., 15);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(new Product());
        Product product1 = new Product(1L, "Eno", 1., 14);
        productService.addingProduct(1L);
        Assert.assertEquals(product, product1);
    }
}