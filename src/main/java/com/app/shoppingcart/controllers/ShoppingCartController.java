package com.app.shoppingcart.controllers;

import com.app.ShoppingCartFacade;
import com.app.shoppingcart.models.ShoppingCart;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/cart")
public class ShoppingCartController  {

    private final ShoppingCartFacade shoppingCartFacade;

    @PostMapping
    public ShoppingCart createCart(@RequestBody ShoppingCart shoppingCart) {
        return shoppingCartFacade.createShoppingCart(shoppingCart);
    }

    @GetMapping(value = "/{id}")
    public Optional<ShoppingCart> findCart(@PathVariable Long id) {
        return shoppingCartFacade.findShoppingCartById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCart(@PathVariable Long id) {
        shoppingCartFacade.deleteShoppingCart(id);
    }
}
