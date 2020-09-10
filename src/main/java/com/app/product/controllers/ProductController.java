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
    @ApiOperation(value = "Cria um novo objeto de Product.")
    public Product saveProductInMemory(@RequestBody Product product) {
        return appFacade.savingProductInMemory(product);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Verifica se o objeto Product existe  pelo id e retorna ele," +
            " caso não exista, imprime mensagem de erro.")
    public Product findProduct(@PathVariable Long id) {
        return appFacade.findProductById(id);
    }

    @GetMapping(value = "/tst")
    @ApiOperation(value = "Retorna um objeto JSON de Product em que o campo id não aparece.")
    public List<ProductDTO> getDTOProductList() {
        return appFacade.getDTOProductList();
    }

    @DeleteMapping
    @ApiOperation(value = "Deleta todos os objetos Product.")
    public void deleteAllProduct() {
        appFacade.deleteAllProducts();
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Deleta um objeto Product pelo seu id.")
    public void deleteProduct(@PathVariable Long id) {
        appFacade.deleteProductById(id);
    }
}
