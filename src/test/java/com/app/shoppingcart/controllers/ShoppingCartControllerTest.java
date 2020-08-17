package com.app.shoppingcart.controllers;

import com.app.facade.AppFacade;
import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.models.ShoppingCartDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartControllerTest {

    @Mock
    AppFacade appFacade;

    @InjectMocks
    ShoppingCartController shoppingCartController;

    @Test
    public void returnShoppingCart_IfObjectIsFound() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCartController.createCart(shoppingCart);
        verify(appFacade, times(1)).createShoppingCart(shoppingCart);
        when(shoppingCartController.createCart(any())).thenReturn(shoppingCart);
    }

    @Test
    public void returnShoppingCartById_IfIdNotNull() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCartController.findCart(shoppingCart.getId());
        verify(appFacade, times(1)).findShoppingCartById(any());
    }

//    @Test
//    public void returnShoppingCartDTOList() {
//        shoppingCartController.getDTOCartList();
//        verify(appFacade, times(1)).getDTOProductList();
//    }

    @Test
    public void deleteShoppingCart_IfIdNotNull() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCartController.deleteCart(shoppingCart.getId());
        verify(appFacade, times(1)).deleteShoppingCart(any());
    }
}