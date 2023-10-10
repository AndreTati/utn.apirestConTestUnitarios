package com.utn.apirest.Controllers;

import com.utn.apirest.Entities.Libro;
import com.utn.apirest.Services.LibroServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "libros")
public class LibroController extends BaseControllerImpl<Libro, LibroServiceImpl> {

    @GetMapping("/buscarPorTitulo")
    public ResponseEntity<?> buscarPorTitulo(@RequestParam String titulo){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorTituloQueryMethod(titulo));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Se produjo el siguiente error."+e+"\"}");
        }
    }
    @GetMapping("/buscarPorAutor")
    public ResponseEntity<?> buscarPorAutor(@RequestParam String autor){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorAutorJPQL(autor));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Se produjo el siguiente error."+e+"\"}");
        }
    }
    @GetMapping("/buscarPorGenero")
    public ResponseEntity<?> buscarPorGenero(@RequestParam String genero){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorGeneroNative(genero));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Se produjo el siguiente error."+e+"\"}");
        }
    }
    @GetMapping("/listPaginada")
    public ResponseEntity<?> findAllPaged(Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAllPaged(pageable));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Se produjo el siguiente error."+e+"\"}");
        }
    }
}
