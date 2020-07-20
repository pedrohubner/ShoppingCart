package com.app.product.services;

import com.app.exceptionhandler.ApiException;
import com.app.product.models.Product;
import com.app.product.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ApiException("Produto não encontrado,", HttpStatus.NOT_FOUND,
                        "Digite o id de um carrinho existente."));
    }

    private Product decreaseProductInventory(Product product) {
        if (product.getAmount() > 0) {
            product.setAmount(product.getAmount() - 1);
            return productRepository.save(product);
        } else {
            throw new ApiException("Estoque zerado", HttpStatus.NO_CONTENT, "");
        }
    }

    private Product increaseProductInventory(Product product) {
        product.setAmount(product.getAmount() + 1);
        return productRepository.save(product);
    }

    public Product addingProduct(Long productId) {
        Product product = findProductById(productId);
        return decreaseProductInventory(product);
    }

    public Product deletingProduct(Long productId) {
        Product product = findProductById(productId);
        return increaseProductInventory(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public void deleteAllProducts() {
        productRepository.deleteAllInBatch();
    }
}