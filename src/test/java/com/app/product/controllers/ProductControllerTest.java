package com.app.product.controllers;

import com.app.facade.AppFacade;
import com.app.product.models.Product;
import com.app.product.models.ProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    AppFacade appFacade;

    @Test
    public void whenBodyPassedAsParamCreateProduct() throws Exception {
        Product product = new Product();

        String parsedStringToJson = new ObjectMapper().writeValueAsString(product);

        when(appFacade.savingProductInMemory(product)).thenReturn(product);

        mockMvc.perform(post("/products")
                .content(mapper.writeValueAsString(product))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(parsedStringToJson))
                .andExpect(status().isOk());
    }

    @Test
    public void whenIdPassedAsParamFindProductByIdIfExists() throws Exception {
        Product product = new Product();

        String parsedStringToJson = new ObjectMapper().writeValueAsString(product);

        when(appFacade.findProductById(1L)).thenReturn(product);

        mockMvc.perform(get("/products/{id}", 1L))
                .andExpect(content().json(parsedStringToJson))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnProductDTOList() throws Exception {
        ProductDTO productDto = new ProductDTO();

        String parsedStringToJson = new ObjectMapper().writeValueAsString(productDto);

        List<String> productDtoList = List.of(parsedStringToJson);

        when(appFacade.getDTOProductList()).thenReturn(List.of(productDto));

        mockMvc.perform(get("/products/tst"))
                .andExpect(content().json(String.valueOf(productDtoList)))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteAllProductsInMemory() throws Exception {
        mockMvc.perform(delete("/products"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteProductsByIdIfProductExists() throws Exception {
        Product product = new Product();

        appFacade.savingProductInMemory(product);

        mockMvc.perform(delete("/products/{id}", 1L))
                .andExpect(status().isOk());
    }
}