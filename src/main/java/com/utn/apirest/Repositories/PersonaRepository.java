package com.utn.apirest.Repositories;

import com.utn.apirest.Entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
    public List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
    @Query(value="SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    public List<Persona>searchJPQL(@Param("filtro") String filtro);
    @Query(value="SELECT * FROMT persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            nativeQuery = true)
    public List<Persona> searchNative(@Param("filtro")String filtro);
}
