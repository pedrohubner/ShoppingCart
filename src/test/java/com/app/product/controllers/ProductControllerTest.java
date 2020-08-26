package com.app.product.controllers;

import com.app.product.models.Product;
import com.app.product.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    ProductService productService;

    @Test
    public void when_Body_Passed_asParam_Create_Product() throws Exception {
        Product product = new Product();

        mockMvc.perform(post("/products")
                .content(mapper.writeValueAsString(product))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void when_Id_Passed_asParam_Find_Product_byId_ifExists() throws Exception {
        Product product = new Product();

        productService.createProduct(product);

        mockMvc.perform(get("/products/{ìd}", 1L))
                .andExpect(status().isOk());
    }

    @Test
    public void should_Return_ProductDTO_List() throws Exception {
        mockMvc.perform(get("/products/tst"))
                .andExpect(status().isOk());
    }

    @Test
    public void should_Delete_All_Products_inMemory() throws Exception {
        mockMvc.perform(delete("/products"))
                .andExpect(status().isOk());
    }

    @Test
    public void should_Delete_Products_byId_ifProductExists() throws Exception {
        Product product = new Product();

        productService.createProduct(product);

        mockMvc.perform(delete("/products/{id}", 1L))
                .andExpect(status().isOk());
    }
}