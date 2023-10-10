package com.utn.apirest.Services;

import com.utn.apirest.Entities.Libro;
import com.utn.apirest.Repositories.BaseRepository;
import com.utn.apirest.Repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl extends BaseServiceImpl<Libro, Long> implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public LibroServiceImpl(BaseRepository<Libro, Long> baseRepository, LibroRepository libroRepository) {
        super(baseRepository);
        this.libroRepository = libroRepository;
    }

    @Override
    public List<Libro> buscarPorTituloQueryMethod(String titulo)throws Exception{
        try{
            return libroRepository.findByTituloContaining(titulo);
        }catch(Exception ex){
            throw new Exception((ex.getMessage()));
        }
    }
    @Override
    public List<Libro> buscarPorAutorJPQL(String autor)throws Exception{
        try{
            return libroRepository.buscarPorAutor(autor);
        }catch(Exception ex){
            throw new Exception((ex.getMessage()));
        }
    }
    @Override
    public List<Libro> buscarPorGeneroNative(String genero)throws Exception{
        try{
            return libroRepository.buscarPorGeneroNative(genero);
        }catch(Exception ex){
            throw new Exception((ex.getMessage()));
        }
    }
    @Override
    public Page<Libro> findAllPaged(Pageable pageable)throws Exception{
        try{
            return libroRepository.findAllPaged(pageable);
        }catch(Exception ex){
            throw new Exception((ex.getMessage()));
        }
    }
}
