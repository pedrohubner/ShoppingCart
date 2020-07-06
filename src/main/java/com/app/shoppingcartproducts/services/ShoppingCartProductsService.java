package com.app.shoppingcartproducts.services;

import com.app.product.models.Product;
import com.app.product.services.ProductService;
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

    private Product getProduct(Long productId) {

        return productService.findProductById(productId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    private ShoppingCart getShoppingCart(Long cartId) {

        return shoppingCartService.findShoppingCartById(cartId)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
    }

    public ShoppingCart addProductToShoppingCart(Long cartId, Long productId) {
        ShoppingCart s = getShoppingCart(cartId);
        s.getProductsList().add(getProduct(productId));
        return shoppingCartRepository.save(s);
    }
}
