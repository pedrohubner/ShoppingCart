package com.app.product.controllers;

import com.app.AppFacade;
import com.app.product.models.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private AppFacade appFacade;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return appFacade.createProduct(product);
    }

    @GetMapping(value = "/{id}")
    public Optional<Product> findProduct(@PathVariable Long id) {
        return appFacade.findProductById(id);
    }

    @DeleteMapping
    public void deleteAllProduct() {
        appFacade.deleteAllProducts();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable Long id) {
        appFacade.deleteProductById(id);
    }
}
