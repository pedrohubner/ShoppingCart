package com.app.shoppingcartproducts.controllers;

import com.app.facade.AppFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartProductsControllerTest {

    @Mock
    AppFacade appFacade;

    @Mock
    ShoppingCartProductsController shoppingCartProductsController;

    @Test
    public void addProductToShoppingCart_ifIdNotNull() {
        shoppingCartProductsController.addProductToShoppingCart(1L, 1L);
        verify(appFacade, times(1)).addProductToShoppingCart(1L, 1L);
    }

    @Test
    public void deleteProductFromShoppingCart_ifIdNotNull() {
        shoppingCartProductsController.removeProductFromShoppingCart(1L, 1L);
        verify(appFacade, times(1)).removeProductFromShoppingCart(1L, 1L);
    }
}