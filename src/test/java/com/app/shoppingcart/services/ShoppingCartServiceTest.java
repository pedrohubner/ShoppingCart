package com.app.shoppingcart.services;

import com.app.product.models.Product;
import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.repositories.ShoppingCartRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class ShoppingCartServiceTest {

    @Mock
    ShoppingCart shoppingCart;

    @Mock
    ShoppingCartRepository shoppingCartRepository;

    @InjectMocks
    ShoppingCartService shoppingCartService;

    @Test
    public void returnShoppingCart_IfItExist() {
        List<Product> products = Arrays.asList();
        ShoppingCart shoppingCart = ShoppingCart.builder()
                .id(1L)
                .productsList(products)
                .build();
        ShoppingCart shoppingCartReturn = shoppingCartRepository.save(shoppingCart);
        Assert.assertEquals(shoppingCart, shoppingCartReturn);
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