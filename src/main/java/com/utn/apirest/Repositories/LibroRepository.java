package com.utn.apirest.Repositories;

import com.utn.apirest.Entities.Libro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends BaseRepository<Libro, Long> {

    //Query methods
    List<Libro>findByTituloContaining(String nombre);

    //JPQL
    @Query(value=
        "SELECT l FROM Libro l WHERE l.autor LIKE %:filtro%")
    List<Libro>buscarPorAutor(@Param("filtro")String autor);

    //Native
    @Query(
            value=
                    "SELECT * FROM libro WHERE genero LIKE %:filtro%",
            nativeQuery = true
    )
    List<Libro>buscarPorGeneroNative(@Param("filtro")String genero);

    @Query(
            value = "SELECT * FROM libro",
            nativeQuery = true
    )
    Page<Libro>findAllPaged(Pageable pageable);
}
