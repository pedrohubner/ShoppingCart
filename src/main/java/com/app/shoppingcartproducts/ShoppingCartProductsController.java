package com.app.shoppingcartproducts;

import com.app.facade.AppFacade;
import com.app.shoppingcart.models.ShoppingCart;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/carts")
@Api(value = "Shopping Cart Products Controller")
public class ShoppingCartProductsController {

    private final AppFacade appFacade;

    @PostMapping(value = "/{cartId}/products/{productId}")
    @ApiOperation(value = "Adiciona um objeto Product dentro da productsList do objeto ShoppingCart.")
    public ShoppingCart addProductToShoppingCart(@PathVariable Long cartId, @PathVariable Long productId) {
        return appFacade.addProductToShoppingCart(cartId, productId);
    }

    @DeleteMapping(value = "/{cartId}/products/{productId}")
    @ApiOperation(value = "Deleta um objeto Product dentro da productsList do objeto ShoppingCart.")
    public ShoppingCart removeProductFromShoppingCart(@PathVariable Long cartId, @PathVariable Long productId) {
        return appFacade.removeProductFromShoppingCart(cartId, productId);
    }
}
