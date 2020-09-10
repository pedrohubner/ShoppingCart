package com.app.facade;

import com.app.product.models.Product;
import com.app.product.models.ProductDTO;
import com.app.product.services.ProductDTOService;
import com.app.product.services.ProductService;
import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.models.ShoppingCartDTO;
import com.app.shoppingcart.repositories.ShoppingCartRepository;
import com.app.shoppingcart.services.ShoppingCartDTOService;
import com.app.shoppingcart.services.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AppFacade {

    private final ProductService productService;
    private final ProductDTOService productDTOService;
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartRepository shoppingCartRepository;
    private final ShoppingCartDTOService shoppingCartDTOService;

    public Product savingProductInMemory(Product product) {
        return productService.savingProductInMemory(product);
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

    public ShoppingCart saveShoppingCartInMemory(ShoppingCart shoppingCart) {
        return shoppingCartService.saveShoppingCartInMemory(shoppingCart);
    }

    public ShoppingCart findShoppingCartById(Long id) {
        return shoppingCartService.findShoppingCartById(id);
    }

    public List<ShoppingCartDTO> getDTOCartList() {
        return shoppingCartDTOService.getAllShoppingCarts();
    }

    public void deleteShoppingCart(Long id) {
        shoppingCartService.deleteShoppingCartById(id);
    }

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
