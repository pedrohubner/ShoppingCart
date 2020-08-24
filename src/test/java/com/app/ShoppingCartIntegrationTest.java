package com.app;

import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.repositories.ShoppingCartRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ShoppingCartIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Test
    public void should_Return_Shopping_CartWhen_Repository_Saves_Shopping_Cart_In_H2() throws Exception{
        ShoppingCart shoppingCart = ShoppingCart.builder()
                .id(1L)
                .build();

        mockMvc.perform(post("/carts")
                .content(objectMapper.writeValueAsString(shoppingCart))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        ShoppingCart shoppingCart1 = shoppingCartRepository.findById(1L).get();

        Assert.assertEquals(shoppingCart1, shoppingCart);
    }

    @Test
    public void should_Return_Shopping_Cart_When_Repository_Finds_Shopping_Cart_By_Id() throws Exception {
        ShoppingCart shoppingCart = ShoppingCart.builder()
                .id(1L)
                .build();

        shoppingCartRepository.save(shoppingCart);

        mockMvc.perform(get("/carts/{id}", 1L)
                .content(objectMapper.writeValueAsString(shoppingCart))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        ShoppingCart shoppingCart1 = shoppingCartRepository.findById(1L).get();

        Assert.assertEquals(shoppingCart1, shoppingCart);
    }

    @Test
    public void should_Delete_Shopping_Cart_When_Repository_Finds_Cart_By_Id() throws Exception {
        ShoppingCart shoppingCart = ShoppingCart.builder()
                .id(1L)
                .build();

        shoppingCartRepository.save(shoppingCart);

        mockMvc.perform(delete("/carts/{id}", 1L)
                .content(objectMapper.writeValueAsBytes(shoppingCart))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
