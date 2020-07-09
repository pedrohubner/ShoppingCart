package com.app.shoppingcartproducts.controllers;

import com.app.ShoppingCartFacade;
import com.app.shoppingcart.models.ShoppingCart;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/cart")
public class ShoppingCartProductsController {

    private final ShoppingCartFacade shoppingCartFacade;

    @GetMapping(value = "/{cartId}/product/{productId}")
    public ShoppingCart addProductToShoppingCart(@PathVariable Long cartId, @PathVariable Long productId) {
        return shoppingCartFacade.addProductToShoppingCart(cartId, productId);
    }
}
