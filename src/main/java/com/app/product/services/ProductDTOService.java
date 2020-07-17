package com.app.product.services;

import com.app.DTOFactory;
import com.app.product.models.ProductDTO;
import com.app.product.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductDTOService {

    private final ProductRepository productRepository;

    public List<ProductDTO> getDTOList() {
        return productRepository.findAll()
                .stream()
                .map(DTOFactory::mapToProductDTO)
                .collect(Collectors.toList());
    }
}
