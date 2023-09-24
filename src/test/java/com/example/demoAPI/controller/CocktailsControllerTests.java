package com.example.demoAPI.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class CocktailsControllerTests {
    @Autowired
    private MockMvc mockMvcController;


    @Test
    public void testGetCocktailNoParameter() throws Exception {
        String expectedValue = "mojito";
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/cocktail"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedValue));
    }

    @Test
    public void testGetCocktailWithParameter() throws Exception {
        String expectedValue = "bloody mary";
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/cocktail").param("name", expectedValue))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedValue));
    }
}
