package com.utn.apirest.Controllers;

import com.utn.apirest.Entities.Persona;
import com.utn.apirest.Services.PersonaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "personas")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl> {

    @GetMapping(path = "/search")
    public ResponseEntity<?> search(@RequestParam String filtro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Se produjo el siguiente error."+e+"\"}");
        }
    }
}
