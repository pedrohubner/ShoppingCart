package com.app.product.services;

import com.app.DTOFactory;
import com.app.product.exceptionhandler.ProductException;
import com.app.product.models.Product;
import com.app.product.models.ProductDTO;
import com.app.product.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductException("Produto não encontrado"));
    }

    private Product decreaseProductInventory(Product product) {
        if (product.getAmount() > 0) {
            product.setAmount(product.getAmount() - 1);
            return productRepository.save(product);
        } else {
            throw new ProductException("Estoque zerado");
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

    public List<ProductDTO> getDTOList() {
        return productRepository.findAll()
                .stream()
                .map(DTOFactory::mapToProductDTO)
                .collect(Collectors.toList());
    }
}