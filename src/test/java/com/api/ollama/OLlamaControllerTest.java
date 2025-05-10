package com.api.ollama;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class OLlamaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGenerate() throws Exception {
        mockMvc.perform(get("/api/v1/generate").param("promptMessage", "Hola")).andExpect(status().isOk());
    }
}