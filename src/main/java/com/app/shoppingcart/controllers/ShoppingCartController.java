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
    @ApiOperation(value = "Cria um novo objeto ShoppingCart.")
    public ShoppingCart saveShoppingCartInMemory(@RequestBody ShoppingCart shoppingCart) {
        return appFacade.saveShoppingCartInMemory(shoppingCart);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Verifica se o objeto ShoppingCart existe pelo seu id e retorna ele, " +
            "caso não exista, exibe mensagem de erro.")
    public ShoppingCart findCart(@PathVariable Long id) {
        return appFacade.findShoppingCartById(id);
    }

    @GetMapping(value = "/tst")
    @ApiOperation(value = "Retorna um objeto JSON de ShoppingCart em que o campo id não aparece.")
    public List<ShoppingCartDTO> getDTOCartList() {
        return appFacade.getDTOCartList();
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Deleta um objeto ShoppingCart pelo seu id")
    public void deleteCart(@PathVariable Long id) {
        appFacade.deleteShoppingCart(id);
    }
}