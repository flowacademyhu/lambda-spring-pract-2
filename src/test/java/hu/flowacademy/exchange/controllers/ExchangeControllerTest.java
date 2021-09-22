package hu.flowacademy.exchange.controllers;

import hu.flowacademy.exchange.services.ExchangeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ComponentScan
@AutoConfigureMockMvc
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ExchangeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ExchangeService exchangeService;

    @BeforeEach
    public void init() {
        when(exchangeService.exchange(anyString(), anyString(), anyDouble())).thenReturn(350.0);
    }

    @Test
    public void testExchange() throws Exception {
        mvc.perform(get("/api/exchange/")
                        .accept(MediaType.APPLICATION_JSON)
                        .param("from", "EUR")
                        .param("to", "HUF")
                        .param("amount", "300")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("350.0"));
    }

}
