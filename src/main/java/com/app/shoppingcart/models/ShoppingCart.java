package com.app.shoppingcart.models;

import com.app.client.Client;
import com.app.product.models.Product;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    @OneToOne
    private final Client client;
    @OneToMany
    private final List<Product> productsList;

    public ShoppingCart(Long id, Client client, List<Product> productsList) {
        this.id = id;
        this.client = client;
        this.productsList = productsList;
    }
}
