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
    public void repository_Should_Save_Product() {
        Product response = new Product();

        Product found = productService.createProduct(response);

        Assert.assertEquals(found, response);
    }

    @Test
    public void when_Find_By_Id_Repository_Should_Return_Product() {
        Product response = Product.builder()
                .id(1L)
                .build();

        productService.createProduct(response);

        Product found = productService.findProductById(1L);

        Assert.assertEquals(found, response);
    }

    @Test(expected = ApiException.class)
    public void repository_Should_Delete_Product_When_Find_By_Id() {
        Product response = Product.builder()
                .id(1L)
                .build();

        productService.createProduct(response);

        productService.deleteProductById(1L);

        productService.findProductById(1L);
    }
}
