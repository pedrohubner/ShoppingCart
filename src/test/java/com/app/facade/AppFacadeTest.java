package com.app.facade;

import com.app.product.services.ProductDTOService;
import com.app.product.services.ProductService;
import com.app.shoppingcart.repositories.ShoppingCartRepository;
import com.app.shoppingcart.services.ShoppingCartDTOService;
import com.app.shoppingcart.services.ShoppingCartService;
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
}