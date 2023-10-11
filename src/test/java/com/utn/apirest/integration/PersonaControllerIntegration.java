package com.utn.apirest.integration;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.utn.apirest.ApirestApplication;
import com.utn.apirest.Entities.Persona;
import com.utn.apirest.Repositories.PersonaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest(classes = ApirestApplication.class) //le pasamos la aplicacion de la clase main
@AutoConfigureMockMvc   //setea automáticamente nuestro mock para realizar peticiones
@TestPropertySource(
        locations = "classpath:application-test.properties")   //en un archivo determinado se coloca toda la información necesaria para el acceso
public class PersonaControllerIntegration {
    /*
    * evaluan el comportamiento conjunto de como los componentes interactúan entre sì
    * */

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonaRepository personaRepository;

    @Test
    void testSearchString()throws Exception{
        Persona persona=new Persona();
        persona.setNombre("Pepe");
        persona.setApellido("Lopez");

        personaRepository.save(persona);

        mockMvc.perform(get("/personas/search")
                .param("filtro", "Pepe")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre", is("Pepe")))
                .andExpect(jsonPath("$[0].apellido", is("Lopez")));
    }
}
