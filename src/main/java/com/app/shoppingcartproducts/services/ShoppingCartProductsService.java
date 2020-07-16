package com.app.shoppingcartproducts.services;

import com.app.product.services.ProductService;
import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.repositories.ShoppingCartRepository;
import com.app.shoppingcart.services.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShoppingCartProductsService {

    private final ProductService productService;
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCart addProductToShoppingCart(Long cartId, Long productId) {
        ShoppingCart sc = shoppingCartService.findShoppingCartById(cartId);
        sc.getProductsList().add(productService.addingProduct(productId));
        return shoppingCartRepository.save(sc);
    }

    public ShoppingCart removeProductFromShoppingCart(Long cartId, Long productId) {
        ShoppingCart sc = shoppingCartService.findShoppingCartById(cartId);
        sc.getProductsList().remove(productService.deletingProduct(productId));
        return shoppingCartRepository.save(sc);
    }
}
