package com.app.shoppingcart.services;

import com.app.DTOFactory;
import com.app.shoppingcart.exceptionhandler.ShoppingCartException;
import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.models.ShoppingCartDTO;
import com.app.shoppingcart.repositories.ShoppingCartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart findShoppingCartById(Long cartId) {
        return shoppingCartRepository.findById(cartId)
                .orElseThrow(() -> new ShoppingCartException("Carrinho não encontrado"));
    }

    public void deleteShoppingCartById(Long id) {
        shoppingCartRepository.deleteById(id);
    }

    public List<ShoppingCartDTO> getDTOList() {
        return shoppingCartRepository.findAll()
                .stream()
                .map(DTOFactory::mapToCartDTO)
                .collect(Collectors.toList());
    }
}
