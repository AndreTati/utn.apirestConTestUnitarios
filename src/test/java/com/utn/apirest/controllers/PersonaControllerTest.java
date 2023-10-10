package com.utn.apirest.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.utn.apirest.Controllers.PersonaController;
import com.utn.apirest.Entities.Persona;
import com.utn.apirest.Services.PersonaServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PersonaController.class)//asegura que el metodo es ejecutado mediante un acceso web
public class PersonaControllerTest {
    @MockBean
    private PersonaServiceImpl personaService;

    @Autowired
    private MockMvc mockMvc;    //ejecutar peticiones dentro de nuestra prueba

    @Test
    void testSearchString()throws Exception{
        Persona persona=new Persona();
        persona.setNombre("Pablo");
        persona.setApellido("Peña");

        List<Persona> listaEnviada=new ArrayList<>();
        listaEnviada.add(persona);

        when(personaService.search("Pablo")).thenReturn(listaEnviada);

        mockMvc.perform(get("/personas/search")
                        .param("filtro", "Pablo")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre", is("Pablo")))
                .andExpect(jsonPath("$[0].apellido", is("Peña")));
    }
}
