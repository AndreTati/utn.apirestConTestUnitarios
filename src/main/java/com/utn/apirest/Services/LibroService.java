package com.utn.apirest.Services;

import com.utn.apirest.Entities.Libro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LibroService extends BaseService<Libro, Long> {

    public List<Libro> buscarPorTituloQueryMethod(String titulo)throws Exception;
    public List<Libro> buscarPorAutorJPQL(String autor)throws Exception;
    public List<Libro> buscarPorGeneroNative(String genero)throws Exception;
    public Page<Libro> findAllPaged(Pageable pageable)throws Exception;
}
