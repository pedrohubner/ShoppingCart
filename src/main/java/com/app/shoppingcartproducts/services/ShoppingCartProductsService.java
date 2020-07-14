package com.app.shoppingcartproducts.services;

import com.app.product.exceptionhandler.ProductException;
import com.app.product.models.Product;
import com.app.product.services.ProductService;
import com.app.shoppingcart.exceptionhandler.ShoppingCartException;
import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.repositories.ShoppingCartRepository;
import com.app.shoppingcart.services.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShoppingCartProductsService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;

    private Product addingProduct(Long productId) {
        Product product = productService.findProductById(productId)
                .orElseThrow(() -> new ProductException("Produto não encontrado"));
        return productService.decreaseProductInventory(product);
    }

    private Product deletingProduct(Long productId) {
        Product product = productService.findProductById(productId)
                .orElseThrow(() -> new ProductException("Produto não encontrado"));
        return productService.increaseProductInventory(product);
    }

    private ShoppingCart getShoppingCart(Long cartId) {
        return shoppingCartService.findShoppingCartById(cartId)
                .orElseThrow(() -> new ShoppingCartException("Carrinho não encontrado"));
    }

    public ShoppingCart addProductToShoppingCart(Long cartId, Long productId) {
        ShoppingCart sc = getShoppingCart(cartId);
        sc.getProductsList().add(addingProduct(productId));
        return shoppingCartRepository.save(sc);
    }

    public ShoppingCart removeProductFromShoppingCart(Long cartId, Long productId) {
        ShoppingCart sc = getShoppingCart(cartId);
        sc.getProductsList().remove(deletingProduct(productId));
        return shoppingCartRepository.save(sc);
    }
}
