package com.app.shoppingcart.controllers;

import com.app.AppFacade;
import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.models.ShoppingCartDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/carts")
public class ShoppingCartController {

    private final AppFacade appFacade;

    @PostMapping
    public ShoppingCart createCart(@RequestBody ShoppingCart shoppingCart) {
        return appFacade.createShoppingCart(shoppingCart);
    }

    @GetMapping(value = "/{id}")
    public ShoppingCart findCart(@PathVariable Long id) {
        return appFacade.findShoppingCartById(id);
    }
//
//    @GetMapping(value = "/tst")
//    public List<ShoppingCartDTO> getDTOCartList() {
//        return appFacade.getDTOCartList();
//    }

    @DeleteMapping(value = "/{id}")
    public void deleteCart(@PathVariable Long id) {
        appFacade.deleteShoppingCart(id);
    }
}