package com.app.shoppingcart.controllers;

import com.app.facade.AppFacade;
import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.models.ShoppingCartDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/carts")
@Api(value = "Shopping Cart Controller")
public class ShoppingCartController {

    private final AppFacade appFacade;

    @PostMapping
    @ApiOperation(value = "Cria um novo cart")
    public ShoppingCart createCart(@RequestBody ShoppingCart shoppingCart) {
        return appFacade.createShoppingCart(shoppingCart);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Verifica se o cart existe e retorna ele")
    public ShoppingCart findCart(@PathVariable Long id) {
        return appFacade.findShoppingCartById(id);
    }

    @GetMapping(value = "/tst")
    @ApiOperation(value = "Retorna cart sem o id")
    public List<ShoppingCartDTO> getDTOCartList() {
        return appFacade.getDTOCartList();
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Deleta cart pelo seu id")
    public void deleteCart(@PathVariable Long id) {
        appFacade.deleteShoppingCart(id);
    }
}