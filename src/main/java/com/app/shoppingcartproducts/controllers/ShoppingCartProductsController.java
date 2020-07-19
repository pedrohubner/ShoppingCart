package com.app.shoppingcartproducts.controllers;

import com.app.AppFacade;
import com.app.CartThread;
import com.app.shoppingcart.models.ShoppingCart;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/carts")
public class ShoppingCartProductsController {

    private final AppFacade appFacade;

    @PostMapping(value = "/{cartId}/products/{productId}")
    public CartThread addProductToShoppingCart(@PathVariable Long cartId, @PathVariable Long productId) {
        return appFacade.addProductToShoppingCart(cartId, productId);
    }

    @DeleteMapping(value = "/{cartId}/products/{productId}")
    public ShoppingCart removeProductFromShoppingCart(@PathVariable Long cartId, @PathVariable Long productId) {
        return appFacade.removeProductFromShoppingCart(cartId, productId);
    }
}
