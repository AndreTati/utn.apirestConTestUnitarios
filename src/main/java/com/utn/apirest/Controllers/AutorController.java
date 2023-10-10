package com.utn.apirest.Controllers;

import com.utn.apirest.Entities.Autor;
import com.utn.apirest.Services.AutorServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "autores")
public class AutorController extends BaseControllerImpl<Autor, AutorServiceImpl> {
}
