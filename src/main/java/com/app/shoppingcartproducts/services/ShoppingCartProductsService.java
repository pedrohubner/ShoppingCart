package com.app.shoppingcartproducts.services;

import com.app.product.models.Product;
import com.app.product.services.ProductService;
import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.repositories.ShoppingCartRepository;
import com.app.shoppingcart.services.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ShoppingCartProductsService {

    private ShoppingCartRepository shoppingCartRepository;
    private ShoppingCartService shoppingCartService;
    private ProductService productService;

    public Product getProduct(Long productId) {
        Optional<Product> product = productService.findProductById(productId);
        if (product.isEmpty()) {
            throw new RuntimeException("Produto não encontrado.");
        }
        return product.get();
    }

    public ShoppingCart getShoppingCart(Long cartId) {
        Optional<ShoppingCart> shoppingCart = shoppingCartService.findShoppingCartById(cartId);
        if (shoppingCart.isEmpty()) {
            throw new RuntimeException("Carrinho não encontrado.");
        }
        return shoppingCart.get();
    }

    public ShoppingCart addProductToShoppingCart(Long productId, Long shoppingCartId) {
        ShoppingCart sc = new ShoppingCart();
        sc.getProductsList().add(getProduct(productId));
        sc = getShoppingCart(shoppingCartId);
        shoppingCartRepository.save(sc);
        return sc;
    }
}
