package com.app;

import com.app.product.models.Product;
import com.app.product.services.ProductService;
import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.services.ShoppingCartService;
import com.app.shoppingcartproducts.services.ShoppingCartProductsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.Semaphore;

@Component
@AllArgsConstructor
public class ShoppingCartFacade {

    private final Semaphore semaphore = new Semaphore(2);
    private final ProductService productService;
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartProductsService shoppingCartProductsService;

    public Product createProduct(Product product) {
        return productService.createProduct(product);
    }

    public Optional<Product> findProductById(Long id) {
        return productService.findProductById(id);
    }

    public void deleteProductById(Long id) {
        productService.deleteProductById(id);
    }

    public void deleteAllProducts() {
        productService.deleteAllProducts();
    }

    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartService.createShoppingCart(shoppingCart);
    }

    public Optional<ShoppingCart> findShoppingCartById(Long id) {
        return shoppingCartService.findShoppingCartById(id);
    }

    public void deleteShoppingCart(Long id) {
        shoppingCartService.deleteShoppingCartById(id);
    }

    public ShoppingCart addProductToShoppingCart(Long cartId, Long productId) {
        return new CartThread(semaphore, shoppingCartProductsService, productId, cartId).getShoppingCart();
    }
}
