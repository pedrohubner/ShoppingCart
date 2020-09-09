package com.app.end2end.shoppingcart;

import com.app.shoppingcart.models.ShoppingCart;
import com.app.shoppingcart.repositories.ShoppingCartRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
    public void shouldDeleteShoppingCartWhenRepositoryFindsCartById() throws Exception {
        ShoppingCart shoppingCart = ShoppingCart.builder()
                .id(1L)
                .build();

        shoppingCartRepository.save(shoppingCart);

        mockMvc.perform(delete("/carts/{id}", 1L))
                .andExpect(status().isOk());
    }
}
