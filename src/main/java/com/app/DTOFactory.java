package com.app;

import com.app.product.models.Product;
import com.app.product.models.ProductDTO;
import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.models.ShoppingCartDTO;

import java.util.stream.Collectors;

public class DTOFactory {

    public static ProductDTO mapToProductDTO(Product product) {
        return ProductDTO.builder()
                .name(product.getName())
                .value(product.getValue())
                .amount(product.getAmount())
                .build();
    }

    public static ShoppingCartDTO mapToCartDTO(ShoppingCart cart) {
        return ShoppingCartDTO.builder()
                .productsList(cart.getProductsList()
                        .stream()
                        .map(DTOFactory::mapToProductDTO)
                        .collect(Collectors.toList()))
                .build();
    }
}
