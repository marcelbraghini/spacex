package br.com.marcelbraghini.springbootpostgres.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PessoaControllerIntegrationtest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getPessoas() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/pessoas").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getPessoaId1() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/pessoas/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
