package ru.t1.practice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class TechnologyControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testShouldGetTechnologies() throws Exception {
        String ans = "{\"technologies\":[{\"id\":14,\"name\":\"Xcode\",\"description\":\"IDE\",\"category\":\"IOS\",\"section\":\"Tools\",\"ring\":\"ADOPT\"}]}";

        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/technology?category=IOS&section=Tools"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().string(ans)
                );
    }

    @Test
    void testShouldBadRequest() throws Exception {
        String ans = "{\"error\":\"Invalid query parameters\",\"details\":{\"category\":\"aaa\",\"section\":\"aaa\"}}";

        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/technology?category=aaa&section=aaa"))
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().string(ans)
                );
    }
}