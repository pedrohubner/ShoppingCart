package com.app.shoppingcart.controllers;

import com.app.facade.AppFacade;
import com.app.shoppingcart.models.ShoppingCart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartControllerTest {

    @Mock
    ShoppingCart shoppingCart;

    @Mock
    AppFacade appFacade;

    @InjectMocks
    ShoppingCartController shoppingCartController;

    @Test
    public void returnShoppingCart_IfObjectIsFound() {
        shoppingCartController.createCart(shoppingCart);
        verify(appFacade, times(1)).createShoppingCart(any());
    }

    @Test
    public void returnShoppingCartById_IfIdNotNull() {
        shoppingCartController.findCart(shoppingCart.getId());
        verify(appFacade, times(1)).findShoppingCartById(any());
    }

    @Test
    public void returnShoppingCartDTOList() {
        shoppingCartController.getDTOCartList();
        verify(appFacade, times(1)).getDTOProductList();
    }

    @Test
    public void deleteShoppingCart_IfIdNotNull() {
        shoppingCartController.deleteCart(shoppingCart.getId());
        verify(appFacade, times(1)).deleteShoppingCart(any());
    }
}