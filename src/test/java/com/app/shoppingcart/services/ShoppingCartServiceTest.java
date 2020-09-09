package com.app.shoppingcart.services;

import com.app.exceptionhandler.ApiException;
import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.repositories.ShoppingCartRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartServiceTest {

    @Mock
    ShoppingCartRepository shoppingCartRepository;

    @InjectMocks
    ShoppingCartService shoppingCartService;

    @Test
    public void mustReturnNewShoppingCartWhenRepositorySavesShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        when(shoppingCartRepository.save(shoppingCart)).thenReturn(shoppingCart);
        ShoppingCart shoppingCart1 = shoppingCartService.createShoppingCart(shoppingCart);
        Assert.assertEquals(shoppingCart, shoppingCart1);
    }

    @Test
    public void mustReturnAShoppingCartWhenItReturnsFullOptional() {
        ShoppingCart shoppingCart = new ShoppingCart();
        when(shoppingCartRepository.findById(1L)).thenReturn(Optional.of(shoppingCart));
        ShoppingCart shoppingCart1 = shoppingCartService.findShoppingCartById(1L);
        Assert.assertEquals(shoppingCart, shoppingCart1);
    }

    @Test(expected = ApiException.class)
    public void mustThrowExceptionWhenItReturnsEmptyOptional() {
        when(shoppingCartRepository.findById(1L)).thenReturn(Optional.empty());
        shoppingCartService.findShoppingCartById(1L);
    }
}