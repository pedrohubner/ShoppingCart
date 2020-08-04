package com.app.shoppingcartproducts.controllers;

import com.app.facade.AppFacade;
import com.app.product.models.Product;
import com.app.shoppingcart.models.ShoppingCart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartProductsControllerTest {

    @Mock
    Product product;

    @Mock
    AppFacade appFacade;

    @Mock
    ShoppingCart shoppingCart;

    @Test
    public void addProductToShoppingCart_ifIdNotNull() {
    }

    @Test
    public void deleteProductFromShoppingCart_ifIdNotNull() {
    }
}