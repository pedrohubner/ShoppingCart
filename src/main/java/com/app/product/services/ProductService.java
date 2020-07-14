package com.app.product.services;

import com.app.product.exceptionhandler.ProductException;
import com.app.product.models.Product;
import com.app.product.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product decreaseProductInventory(Product product) {
        if (product.getAmount() > 0) {
            product.setAmount(product.getAmount() - 1);
            return productRepository.save(product);
        }
        else {
            throw new ProductException("Estoque zerado");
        }
    }

    public Product increaseProductInventory(Product product) {
        product.setAmount(product.getAmount() + 1);
        return productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public void deleteAllProducts() {
        productRepository.deleteAllInBatch();
    }
}