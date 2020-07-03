package com.app.shoppingcartproducts.controllers;

import com.app.AppFacade;
import com.app.shoppingcart.models.ShoppingCart;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/shopcart")
public class ShoppingCartProductsController {

    private AppFacade appFacade;

    @GetMapping(value = "/cart/{cartId}/product/{productId}")
    public ShoppingCart addProductToShoppingCart(@PathVariable Long productId, Long cartId) {
        return appFacade.addProductToShoppingCart(productId, cartId);
    }
}
