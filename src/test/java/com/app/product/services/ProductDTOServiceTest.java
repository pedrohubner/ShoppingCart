package com.app.product.services;

import com.app.product.models.Product;
import com.app.product.models.ProductDTO;
import com.app.product.repositories.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductDTOServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductDTOService productDTOService;

    @Test
    public void returnProductDtoListWhenRepositoryFindProductList() {
        List<ProductDTO> productList2 = List.of(new ProductDTO());

        when(productRepository.findAll()).thenReturn(List.of(new Product()));

        List<ProductDTO> response = productDTOService.getDTOList();
        Assert.assertEquals(productList2, response);
    }
}