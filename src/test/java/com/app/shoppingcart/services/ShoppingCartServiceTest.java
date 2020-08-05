package com.app.shoppingcart.services;

import com.app.exceptionhandler.ApiException;
import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.repositories.ShoppingCartRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class ShoppingCartServiceTest {

    @Mock
    ShoppingCartRepository shoppingCartRepository;

    @InjectMocks
    ShoppingCartService shoppingCartService;

    @Test
    public void returnShoppingCart_IfItExist() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCartService.createShoppingCart(shoppingCart);
        verify(shoppingCartRepository, times(1)).save(shoppingCart);
    }

    @Test
    public void findShoppingCartById_IfIdNotNull() {
        ShoppingCart shoppingCart = new ShoppingCart();
        when(shoppingCartRepository.findById(any())).thenReturn(Optional.of(shoppingCart));
        shoppingCartService.findShoppingCartById(52641116484L);
        verify(shoppingCartRepository, times(1)).findById(any());
    }

    @Test(expected = ApiException.class)
    public void whenNonExistingIdIsPassed_throwException() {
        shoppingCartService.findShoppingCartById(1L);
        when(shoppingCartRepository.findById(1L)).thenReturn(Optional.empty());
    }

    @Test
    public void deleteShoppingCart_IfItExist() {
        shoppingCartService.deleteShoppingCartById(1L);
        verify(shoppingCartRepository, times(1)).deleteById(1L);
    }
}