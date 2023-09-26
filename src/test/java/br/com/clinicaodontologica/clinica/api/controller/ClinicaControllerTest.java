package br.com.clinicaodontologica.clinica.api.controller;

import br.com.clinicaodontologica.clinica.domain.entity.Clinica;
import br.com.clinicaodontologica.clinica.domain.service.ClinicaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ClinicaControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private ClinicaService service;


    @Test
    public void check () throws Exception {
        Mockito.when(service.buscarClinicas(null)).thenReturn(clinicaList());
       this.mvc.perform(MockMvcRequestBuilders.get("/v1/clinicas"))
               .andDo(print())
               .andExpect(status().isOk());

    }

    private List <Clinica> clinicaList (){
        Clinica clinica1 = new Clinica();
        clinica1.setId(UUID.randomUUID());
        clinica1.setNome(clinica1.getNome());

        Clinica clinica2 = new Clinica();
        clinica2.setId(UUID.randomUUID());
        clinica2.setNome(clinica2.getNome());

        Clinica clinica3 = new Clinica();
        clinica3.setId(UUID.randomUUID());
        clinica3.setNome(clinica3.getNome());

        Clinica clinica4 = new Clinica();
        clinica4.setId(UUID.randomUUID());
        clinica4.setNome(clinica4.getNome());

        Clinica clinica5 = new Clinica();
        clinica5.setId(UUID.randomUUID());
        clinica5.setNome(clinica5.getNome());

        return List.of(clinica1,clinica2,clinica3,clinica4,clinica5);

    }




}