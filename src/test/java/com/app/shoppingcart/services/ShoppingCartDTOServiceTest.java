package com.app.shoppingcart.services;

import com.app.product.models.Product;
import com.app.product.models.ProductDTO;
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
    public void returnShoppingCartDtoListWhenRepositoryFindShoppingCartList() {
        List<Product> productList = List.of(new Product());
        when(shoppingCartRepository.findAll()).thenReturn(List.of(new ShoppingCart(1L, productList)));

        List<ShoppingCartDTO> shoppingCartDTOList = List.of(new ShoppingCartDTO(List.of(new ProductDTO())));
        List<ShoppingCartDTO> response = shoppingCartDTOService.getAllShoppingCarts();

        Assert.assertEquals(shoppingCartDTOList, response);
    }

    @Test
    public void returnNullProductListWhenRepositoryFindShoppingCartList() {
        when(shoppingCartRepository.findAll()).thenReturn(List.of(new ShoppingCart()));

        List<ShoppingCartDTO> response = shoppingCartDTOService.getAllShoppingCarts();

        ShoppingCartDTO shoppingCart1 = response.get(0);
        List<ProductDTO> productDTOS = shoppingCart1.getProductsList();

        Assert.assertNull(productDTOS);
    }
}