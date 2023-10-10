package com.utn.apirest.Entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Autor extends Base{

    private String nombre;
    private String apellido;
    private String biografía;
}
