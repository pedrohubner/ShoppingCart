package com.app.product.controllers;

import com.app.facade.AppFacade;
import com.app.product.models.Product;
import com.app.product.models.ProductDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final AppFacade appFacade;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return appFacade.createProduct(product);
    }

    @GetMapping(value = "/{id}")
    public Product findProduct(@PathVariable Long id) {
        return appFacade.findProductById(id);
    }

    @GetMapping(value = "/tst")
    public List<ProductDTO> getDTOProductList() {
        return appFacade.getDTOProductList();
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
