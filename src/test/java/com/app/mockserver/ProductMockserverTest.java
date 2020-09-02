package com.app.mockserver;

import com.app.product.models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpError;
import org.mockserver.model.HttpForward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpClassCallback.callback;
import static org.mockserver.model.HttpForward.forward;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductMockserverTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    ClientAndServer mockServer;

    @Before
    public void startMockServer() {
        mockServer = startClientAndServer(1080);
    }

    @Test
    public void when_Request_isMade_Should_Return_Product() throws Exception {
        mockServer
                .when(request()
                        .withMethod("POST")
                        .withHeader("Content-Type", "application/json")
                        .withPath("/products")
                )
                .respond(response()
                        .withStatusCode(200)
                        .withReasonPhrase("Produto criado")
                        .withBody("{id: 1, name: 'Azitromicina', value: 21.0, amount: 12}")
                );

        mockMvc.perform(post("/products")
                .content(mapper.writeValueAsString(new Product()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void forward_Test_Example() throws Exception {
        mockServer
                .when(request()
                        .withPath("/products")
                        .withHeader("Content-Type", "application/json")
                        .withMethod("POST")
                )
                .forward(forward()
                        .withHost("google.com")
                        .withPort(80)
                        .withScheme(HttpForward.Scheme.HTTP)
                );

        mockMvc.perform(post("/products")
                .content(mapper.writeValueAsString(new Product()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void forward_Should_Return_TestCallBack_Response() throws Exception {
        mockServer
                .when(request()
                        .withPath("/products")
                        .withHeader("Content-Type", "application/json")
                        .withMethod("POST")
                )
                .forward(callback()
                        .withCallbackClass(TestCallbackClass.class)
                );

        mockMvc.perform(post("/products")
                .content(mapper.writeValueAsString(new Product()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void should_Return_TestCallBack_Response() throws Exception {
        mockServer
                .when(request()
                        .withMethod("POST")
                        .withHeader("Content-Type", "application/json")
                        .withPath("/products")
                )
                .respond(callback()
                        .withCallbackClass(TestCallbackClass.class)
                );

        mockMvc.perform(post("/products")
                .content(mapper.writeValueAsString(new Product()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void should_Close_Connection_withMockServer() throws Exception {
        mockServer
                .when(request()
                        .withMethod("POST")
                        .withHeader("Content-Type", "application/json")
                        .withPath("/products")
                )
                .error(HttpError.error()
                        .withDropConnection(true)
                );

        mockMvc.perform(post("/products")
                .content(mapper.writeValueAsString(new Product()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
