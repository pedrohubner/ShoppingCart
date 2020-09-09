package com.app.product.controllers;

import com.app.facade.AppFacade;
import com.app.product.models.Product;
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

        String parsed = new ObjectMapper().writeValueAsString(product);

        when(appFacade.createProduct(product)).thenReturn(product);

        mockMvc.perform(post("/products")
                .content(mapper.writeValueAsString(product))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(parsed))
                .andExpect(status().isOk());
    }

    @Test
    public void whenIdPassedAsParamFindProductByIdIfExists() throws Exception {
        Product product = new Product();

        String parsed = new ObjectMapper().writeValueAsString(product);

        when(appFacade.findProductById(1L)).thenReturn(product);

        mockMvc.perform(get("/products/{id}", 1L))
                .andExpect(content().json(parsed))
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

        appFacade.createProduct(product);

        mockMvc.perform(delete("/products/{id}", 1L))
                .andExpect(status().isOk());
    }
}