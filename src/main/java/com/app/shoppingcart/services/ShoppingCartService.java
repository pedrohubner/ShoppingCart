package com.app.shoppingcart.services;

import com.app.exceptionhandler.ApiException;
import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.repositories.ShoppingCartRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart findShoppingCartById(Long cartId) {
        return shoppingCartRepository.findById(cartId)
                .orElseThrow(() -> new ApiException("Carrinho não encontrado", HttpStatus.NOT_FOUND,
                        "Digite o id de um carrinho existente."));
    }

    public void deleteShoppingCartById(Long id) {
        shoppingCartRepository.deleteById(id);
    }
}
