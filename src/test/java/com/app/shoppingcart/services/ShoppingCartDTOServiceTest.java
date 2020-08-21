package com.app.shoppingcart.services;

import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.models.ShoppingCartDTO;
import com.app.shoppingcart.repositories.ShoppingCartRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartDTOServiceTest {

    @Mock
    ShoppingCartRepository shoppingCartRepository;

    @InjectMocks
    ShoppingCartDTOService shoppingCartDTOService;

    @Test
    public void return_Shopping_Cart_Dto_List_When_Repository_Find_Shopping_Cart_List() {
        when(shoppingCartRepository.findAll()).thenReturn(List.of(new ShoppingCart()));

        List<ShoppingCartDTO> shoppingCartDTOList = List.of(new ShoppingCartDTO());
        List<ShoppingCartDTO> response = shoppingCartDTOService.getDTOList();

        Assert.assertEquals(shoppingCartDTOList, response);
    }
}