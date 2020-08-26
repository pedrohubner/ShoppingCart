package com.app.integration.shoppingcart;

import com.app.exceptionhandler.ApiException;
import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.services.ShoppingCartService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShoppingCartIntegrationTest {

    @Autowired
    ShoppingCartService shoppingCartService;

    @Test
    public void repository_Should_Save_ShoppingCart() {
        ShoppingCart response = new ShoppingCart();

        ShoppingCart found = shoppingCartService.createShoppingCart(response);

        Assert.assertEquals(found, response);
    }

    @Test
    public void whenFindById_shouldReturnProduct() {
        ShoppingCart response = ShoppingCart.builder()
                .id(1L)
                .build();

        shoppingCartService.createShoppingCart(response);

        ShoppingCart found = shoppingCartService.findShoppingCartById(1L);

        Assert.assertEquals(found, response);
    }

    @Test(expected = ApiException.class)
    public void repository_Should_Delete_ShoppingCart_When_Find_By_Id() {
        ShoppingCart response = ShoppingCart.builder()
                .id(1L)
                .build();

        shoppingCartService.createShoppingCart(response);

        shoppingCartService.deleteShoppingCartById(1L);

        shoppingCartService.findShoppingCartById(1L);
    }
}
