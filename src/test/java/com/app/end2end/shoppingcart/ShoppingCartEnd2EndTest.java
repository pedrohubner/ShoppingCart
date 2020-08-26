package com.app.end2end.shoppingcart;

import com.app.product.models.Product;
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

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ShoppingCartEnd2EndTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Test
    public void should_Return_Shopping_CartWhen_Repository_Saves_Shopping_Cart_In_H2() throws Exception{
        List<Product> productList = new ArrayList<>();

        ShoppingCart shoppingCart = ShoppingCart.builder()
                .id(1L)
                .productsList(productList)
                .build();

        mockMvc.perform(post("/carts")
                .content(objectMapper.writeValueAsString(shoppingCart))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        ShoppingCart shoppingCart1 = shoppingCartRepository.findById(1L).get();

        Assert.assertEquals(shoppingCart1.getProductsList(), shoppingCart.getProductsList());
    }

    @Test
    public void should_Return_Shopping_Cart_When_Repository_Finds_Shopping_Cart_By_Id() throws Exception {
        List<Product> productList = new ArrayList<>();

        ShoppingCart shoppingCart = ShoppingCart.builder()
                .id(1L)
                .productsList(productList)
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

        mockMvc.perform(delete("/carts/{id}", 1L))
                .andExpect(status().isOk());
    }
}
