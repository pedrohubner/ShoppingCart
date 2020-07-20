package com.app.facade;

import com.app.CartThread;
import com.app.product.models.Product;
import com.app.product.models.ProductDTO;
import com.app.product.services.ProductDTOService;
import com.app.product.services.ProductService;
import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.models.ShoppingCartDTO;
import com.app.shoppingcart.services.ShoppingCartDTOService;
import com.app.shoppingcart.services.ShoppingCartService;
import com.app.shoppingcartproducts.services.ShoppingCartProductsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Semaphore;

@Component
@AllArgsConstructor
public class AppFacade {

    private final ProductService productService;
    private final ProductDTOService productDTOService;
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartDTOService shoppingCartDTOService;
    private final Semaphore semaphore = new Semaphore(2);
    private final ShoppingCartProductsService shoppingCartProductsService;

    public Product createProduct(Product product) {
        return productService.createProduct(product);
    }

    public Product findProductById(Long id) {
        return productService.findProductById(id);
    }

    public List<ProductDTO> getDTOProductList() {
        return productDTOService.getDTOList();
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

    public ShoppingCart findShoppingCartById(Long id) {
        return shoppingCartService.findShoppingCartById(id);
    }

    public List<ShoppingCartDTO> getDTOCartList() {
        return shoppingCartDTOService.getDTOList();
    }

    public void deleteShoppingCart(Long id) {
        shoppingCartService.deleteShoppingCartById(id);
    }

    public CartThread addProductToShoppingCart(Long cartId, Long productId) {
        return new CartThread(semaphore, shoppingCartProductsService, cartId, productId);
    }

    public ShoppingCart removeProductFromShoppingCart(Long cartId, Long productId) {
        return shoppingCartProductsService.removeProductFromShoppingCart(cartId, productId);
    }
}
