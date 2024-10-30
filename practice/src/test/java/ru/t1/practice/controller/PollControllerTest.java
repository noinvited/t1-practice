package ru.t1.practice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.t1.practice.dto.PollRequest;

import java.nio.charset.StandardCharsets;

@SpringBootTest
@AutoConfigureMockMvc
class PollControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testShouldPostPoll() throws Exception {
        PollRequest pollRequest = new PollRequest(3, "BACKLOG");
        String request = new ObjectMapper().writeValueAsString(pollRequest);

        String ans =  "{\"message\":\"Результат опроса успешно добавлен\"}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/poll")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(request).characterEncoding(StandardCharsets.UTF_8))
                .andExpect(MockMvcResultMatchers.status().is(201))
                .andExpect(MockMvcResultMatchers.content().string(ans)
                );

    }

    @Test
    void testShouldBadRequest() throws Exception {
        PollRequest pollRequest = new PollRequest(6, "AAAA");
        String request = new ObjectMapper().writeValueAsString(pollRequest);

        String ans =  "{\"code\":400,\"message\":\"BAD_REQUEST\"}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/poll")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(request))
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().string(ans)
                );
    }

    @Test
    void testShouldTechnologyNotFound() throws Exception {
        PollRequest pollRequest = new PollRequest(52, "HOLD");
        String request = new ObjectMapper().writeValueAsString(pollRequest);

        String ans =  "{\"code\":404,\"message\":\"TECHNOLOGY_NOT_FOUND\"}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/poll")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(request))
                .andExpect(MockMvcResultMatchers.status().is(404))
                .andExpect(MockMvcResultMatchers.content().string(ans)
                );
    }

}