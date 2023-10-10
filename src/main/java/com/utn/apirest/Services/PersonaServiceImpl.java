package com.utn.apirest.Services;

import com.utn.apirest.Entities.Persona;
import com.utn.apirest.Repositories.BaseRepository;
import com.utn.apirest.Repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository, PersonaRepository personaRepository) {
        super(baseRepository);
        this.personaRepository = personaRepository;
    }

    @Transactional
    @Override
    public List<Persona>search(String filtro)throws Exception{
        try{
            //return personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            //return personaRepository.searchJPQL(filtro);
            return personaRepository.searchNative(filtro);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
