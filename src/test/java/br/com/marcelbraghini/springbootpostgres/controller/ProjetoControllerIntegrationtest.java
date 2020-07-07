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
public class ProjetoControllerIntegrationtest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getProjetos() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/projetos").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getProjetosId1() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/projetos/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
