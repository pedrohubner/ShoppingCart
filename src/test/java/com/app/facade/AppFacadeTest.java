package com.app.facade;

import com.app.product.services.ProductDTOService;
import com.app.product.services.ProductService;
import com.app.shoppingcart.repositories.ShoppingCartRepository;
import com.app.shoppingcart.services.ShoppingCartDTOService;
import com.app.shoppingcart.services.ShoppingCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AppFacadeTest {

    @Mock
    ProductService productService;

    @Mock
    ProductDTOService productDTOService;

    @Mock
    ShoppingCartService shoppingCartService;

    @Mock
    ShoppingCartRepository shoppingCartRepository;

    @Mock
    ShoppingCartDTOService shoppingCartDTOService;

    @InjectMocks
    AppFacade appFacade;

    @Test
    public void createProduct() {
    }

    @Test
    public void findProductById() {
    }

    @Test
    public void getDTOProductList() {
    }

    @Test
    public void deleteProductById() {
    }

    @Test
    public void deleteAllProducts() {
    }

    @Test
    public void createShoppingCart() {
    }

    @Test
    public void findShoppingCartById() {
    }

    @Test
    public void getDTOCartList() {
    }

    @Test
    public void deleteShoppingCart() {
    }

    @Test
    public void addProductToShoppingCart() {
    }

    @Test
    public void removeProductFromShoppingCart() {
    }
}