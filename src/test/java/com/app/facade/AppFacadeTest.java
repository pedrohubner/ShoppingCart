package com.app.facade;

import com.app.product.models.Product;
import com.app.product.services.ProductDTOService;
import com.app.product.services.ProductService;
import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.services.ShoppingCartDTOService;
import com.app.shoppingcart.services.ShoppingCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AppFacadeTest {

    @Mock
    ProductService productService;

    @Mock
    ProductDTOService productDTOService;

    @Mock
    ShoppingCartService shoppingCartService;

    @Mock
    ShoppingCartDTOService shoppingCartDTOService;

    @InjectMocks
    AppFacade appFacade;

    @Test
    public void createProduct() {
        Product product = new Product();
        appFacade.createProduct(product);
        verify(productService, times(1)).createProduct(product);
    }

    @Test
    public void findProductById() {
        appFacade.findProductById(1L);
        verify(productService, times(1)).findProductById(1L);
    }

    @Test
    public void getDTOProductList() {
        appFacade.getDTOProductList();
        verify(productDTOService, times(1)).getDTOList();
    }

    @Test
    public void deleteProductById() {
        appFacade.deleteProductById(1L);
        verify(productService, times(1)).deleteProductById(1L);
    }

    @Test
    public void deleteAllProducts() {
        appFacade.deleteAllProducts();
        verify(productService, times(1)).deleteAllProducts();
    }

    @Test
    public void createShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        appFacade.createShoppingCart(shoppingCart);
        verify(shoppingCartService, times(1)).createShoppingCart(shoppingCart);
    }

    @Test
    public void findShoppingCartById() {
        appFacade.findShoppingCartById(1L);
        verify(shoppingCartService, times(1)).findShoppingCartById(1L);
    }

    @Test
    public void getDTOCartList() {
        appFacade.getDTOCartList();
        verify(shoppingCartDTOService, times(1)).getDTOList();
    }

    @Test
    public void deleteShoppingCart() {
        appFacade.deleteShoppingCart(1L);
        verify(shoppingCartService, times(1)).deleteShoppingCartById(1L);
    }

    @Test
    public void addProductToShoppingCart() {
//        appFacade.addProductToShoppingCart(1L, 1L);
//        when(shoppingCartService.findShoppingCartById(1L)).thenReturn(shoppingCart);
    }

    @Test
    public void removeProductFromShoppingCart() {
        appFacade.removeProductFromShoppingCart(1L, 1L);
//        verify(shoppingCartService.findShoppingCartById())
    }
}