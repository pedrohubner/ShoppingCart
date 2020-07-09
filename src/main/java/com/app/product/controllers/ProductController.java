package com.app.product.controllers;

import com.app.ShoppingCartFacade;
import com.app.product.models.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private final ShoppingCartFacade shoppingCartFacade;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return shoppingCartFacade.createProduct(product);
    }

    @GetMapping(value = "/{id}")
    public Optional<Product> findProduct(@PathVariable Long id) {
        return shoppingCartFacade.findProductById(id);
    }

    @DeleteMapping
    public void deleteAllProduct() {
        shoppingCartFacade.deleteAllProducts();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable Long id) {
        shoppingCartFacade.deleteProductById(id);
    }
}
