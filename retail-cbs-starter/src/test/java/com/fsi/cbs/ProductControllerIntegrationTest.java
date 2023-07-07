package com.fsi.cbs;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fsi.cbs.country.repo.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author med-amine.Dahmen
 * Date 06/07/2023
 */
@SpringBootTest(classes = {PaymentSystemApplication.class})
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp(WebApplicationContext context) {
        // Perform any setup tasks here
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testGetAllProducts() throws Exception {
        // Create a GET request to "/users/{id}" endpoint
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/products")
                        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andReturn();

        // Retrieve the response body
        String responseBody = mvcResult.getResponse().getContentAsString();

        // Parse the response body into a User object using Jackson ObjectMapper
        List<Product> products = objectMapper.readValue(responseBody, new TypeReference<>() {
        });

        // Perform assertions
        assertNotNull(products);
        // Add more assertions as needed
    }

    // Add more test methods for other endpoints or scenarios
}
