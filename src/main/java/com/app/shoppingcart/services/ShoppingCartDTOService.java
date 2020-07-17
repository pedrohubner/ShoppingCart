package com.app.shoppingcart.services;

import com.app.DTOFactory;
import com.app.shoppingcart.models.ShoppingCartDTO;
import com.app.shoppingcart.repositories.ShoppingCartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShoppingCartDTOService {

    private final ShoppingCartRepository shoppingCartRepository;

    public List<ShoppingCartDTO> getDTOList() {
        return shoppingCartRepository.findAll()
                .stream()
                .map(DTOFactory::mapToCartDTO)
                .collect(Collectors.toList());
    }
}