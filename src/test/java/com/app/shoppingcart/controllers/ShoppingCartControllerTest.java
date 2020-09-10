package com.app.shoppingcart.controllers;

import com.app.facade.AppFacade;
import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.models.ShoppingCartDTO;
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
public class ShoppingCartControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    AppFacade appFacade;

    @Test
    public void whenCartSavedInMemoryReturnCartBody() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();

        String parsedStringToJson = mapper.writeValueAsString(shoppingCart);

        when(appFacade.saveShoppingCartInMemory(shoppingCart)).thenReturn(shoppingCart);

        mockMvc.perform(post("/carts")
                .content(parsedStringToJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(parsedStringToJson))
                .andExpect(status().isOk());
    }

    @Test
    public void whenFindCartInMemoryByIdReturnCartBody() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();

        String parsedStringToJson = mapper.writeValueAsString(shoppingCart);

        when(appFacade.findShoppingCartById(1L)).thenReturn(shoppingCart);

        mockMvc.perform(get("/carts/{id}", 1L))
                .andExpect(content().json(parsedStringToJson))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnShoppingCartDtoList() throws Exception {
        ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();

        String parsedStringToJson = mapper.writeValueAsString(shoppingCartDTO);

        List<String> shoppingCartDtoList = List.of(parsedStringToJson);

        when(appFacade.getDTOCartList()).thenReturn(List.of(shoppingCartDTO));

        mockMvc.perform(get("/carts/tst"))
                .andExpect(content().json(String.valueOf(shoppingCartDtoList)))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteShoppingCartsInMemoryById() throws Exception {
        mockMvc.perform(delete("/carts/{id}", 1L))
                .andExpect(status().isOk());
    }
}