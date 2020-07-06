package com.app.shoppingcart.models;

import com.app.client.models.Client;
import com.app.product.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@AllArgsConstructor
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    @OneToOne
    private final Client client;
    @OneToMany
    private final List<Product> productsList;
}
