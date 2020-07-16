package com.app;

import com.app.product.models.Product;
import com.app.product.models.ProductDTO;
import com.app.product.services.ProductService;
import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.models.ShoppingCartDTO;
import com.app.shoppingcart.services.ShoppingCartService;
import com.app.shoppingcartproducts.services.ShoppingCartProductsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AppFacade {

    private final ProductService productService;
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartProductsService shoppingCartProductsService;

    public Product createProduct(Product product) {
        return productService.createProduct(product);
    }

    public Product findProductById(Long id) {
        return productService.findProductById(id);
    }

    public List<ProductDTO> getDTOProductList() {
        return productService.getDTOList();
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

//    public List<ShoppingCartDTO> getDTOCartList() {
//        return shoppingCartService.getDTOList();
//    }

    public void deleteShoppingCart(Long id) {
        shoppingCartService.deleteShoppingCartById(id);
    }

    public ShoppingCart addProductToShoppingCart(Long cartId, Long productId) {
        return shoppingCartProductsService.addProductToShoppingCart(cartId, productId);
    }

    public ShoppingCart removeProductFromShoppingCart(Long cartId, Long productId) {
        return shoppingCartProductsService.removeProductFromShoppingCart(cartId, productId);
    }
}
