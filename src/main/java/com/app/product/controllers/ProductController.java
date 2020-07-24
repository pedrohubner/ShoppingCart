package com.app.product.controllers;

import com.app.facade.AppFacade;
import com.app.product.models.Product;
import com.app.product.models.ProductDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/products")
@Api(value = "API Rest Product")
public class ProductController {

    private final AppFacade appFacade;

    @PostMapping
    @ApiOperation(value = "Cria um novo product")
    public Product createProduct(@RequestBody Product product) {
        return appFacade.createProduct(product);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Verifica se o product existe e retorna ele")
    public Product findProduct(@PathVariable Long id) {
        return appFacade.findProductById(id);
    }

    @GetMapping(value = "/tst")
    @ApiOperation(value = "Retorna um product sem o id")
    public List<ProductDTO> getDTOProductList() {
        return appFacade.getDTOProductList();
    }

    @DeleteMapping
    @ApiOperation(value = "Deleta todos os products")
    public void deleteAllProduct() {
        appFacade.deleteAllProducts();
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Deleta um product pelo seu id")
    public void deleteProduct(@PathVariable Long id) {
        appFacade.deleteProductById(id);
    }
}
