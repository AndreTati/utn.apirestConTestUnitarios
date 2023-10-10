package com.utn.apirest.services;

import com.utn.apirest.Entities.Persona;
import com.utn.apirest.Repositories.PersonaRepository;
import com.utn.apirest.Services.PersonaServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PersonaServiceImplTest {
    @MockBean   //simular un comportamiento, simula una llamada que no dependa del funcionamiento del repositorio
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaServiceImpl personaService;

    @Test
    void testSearchString()throws Exception{
        Persona persona=new Persona();
        persona.setNombre("Pablo");
        persona.setApellido("Peña");

        List<Persona> listaEnviada=new ArrayList<>();
        listaEnviada.add(persona);

        when(personaRepository.searchNative("Pablo")).thenReturn(listaEnviada);

        assertEquals(listaEnviada, personaRepository.searchNative("Pablo"));

    }
}
