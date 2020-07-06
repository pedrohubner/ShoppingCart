package com.app.shoppingcart.services;

import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.repositories.ShoppingCartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    public Optional<ShoppingCart> findShoppingCartById(Long id) {
        return shoppingCartRepository.findById(id);
    }

    public void deleteShoppingCartById(Long id) {
        shoppingCartRepository.deleteById(id);
    }
}
