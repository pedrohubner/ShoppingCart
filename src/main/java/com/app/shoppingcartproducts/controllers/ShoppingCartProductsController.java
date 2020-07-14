package com.app.shoppingcartproducts.controllers;

import com.app.AppFacade;
import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcartproducts.services.ShoppingCartProductsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/cart")
public class ShoppingCartProductsController {

    private final AppFacade appFacade;

    @PostMapping(value = "/{cartId}/product/{productId}")
    public ShoppingCart addProductToShoppingCart(@PathVariable Long cartId, @PathVariable Long productId) {
        return appFacade.addProductToShoppingCart(cartId, productId);
    }

    @DeleteMapping(value = "/{cartId}/product/{productId}")
    public ShoppingCart removeProductFromShoppingCart(@PathVariable Long cartId, @PathVariable Long productId) {
        return appFacade.removeProductFromShoppingCart(cartId, productId);
    }
}
