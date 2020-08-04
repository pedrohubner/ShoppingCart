package com.app.shoppingcart.services;

import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.repositories.ShoppingCartRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartServiceTest {

    @Mock
    ShoppingCart shoppingCart;

    @Mock
    ShoppingCartRepository shoppingCartRepository;

    @InjectMocks
    ShoppingCartService shoppingCartService;

    @Test
    public void returnShoppingCart_IfItExist() {
        shoppingCartService.createShoppingCart(shoppingCart);
        verify(shoppingCartRepository, times(1)).save(any());
    }

    @Test
    public void findShoppingCartById_IfIdNotNull() {
        shoppingCartService.findShoppingCartById(1L);
        verify(shoppingCartRepository, times(1)).findById(any());
    }

    @Test
    public void deleteShoppingCart_IfItExist() {
        shoppingCartService.deleteShoppingCartById(shoppingCart.getId());
        verify(shoppingCartRepository, times(1)).deleteById(any());
    }
}