package com.app.integration.product;

import com.app.exceptionhandler.ApiException;
import com.app.product.models.Product;
import com.app.product.services.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductIntegrationTest {

    @Autowired
    ProductService productService;

    @Test
    public void repositoryShouldSaveProduct() {
        Product response = new Product();

        Product found = productService.savingProductInMemory(response);

        Assert.assertEquals(found, response);
    }

    @Test
    public void whenFindByIdRepositoryShouldReturnProduct() {
        Product response = Product.builder()
                .id(1L)
                .build();

        productService.savingProductInMemory(response);

        Product found = productService.findProductById(1L);

        Assert.assertEquals(found, response);
    }

    @Test(expected = ApiException.class)
    public void repositoryShouldDeleteProductWhenFindById() {
        Product response = Product.builder()
                .id(1L)
                .build();

        productService.savingProductInMemory(response);

        productService.deleteProductById(1L);

        productService.findProductById(1L);
    }
}
