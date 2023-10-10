package com.utn.apirest.repositories;

import com.utn.apirest.Entities.Persona;
import com.utn.apirest.Repositories.PersonaRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PersonaRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PersonaRepository personaRepository;

    @Test
    void testSearchString(){
        Persona persona=new Persona();
        persona.setNombre("Pablo");
        persona.setApellido("Peña");

        List<Persona> listaEnviada=new ArrayList<>();
        listaEnviada.add(persona);

        entityManager.persist(persona);
        entityManager.flush();

        assertEquals(listaEnviada, personaRepository.searchNative("Pablo"));
        assertEquals(listaEnviada, personaRepository.searchNative("Peña"));
    }
}
