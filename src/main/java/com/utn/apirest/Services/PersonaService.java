package com.utn.apirest.Services;

import com.utn.apirest.Entities.Persona;

import java.util.List;

public interface PersonaService extends BaseService<Persona, Long> {
    public List<Persona> search(String filtro)throws Exception;
}
