package com.utn.apirest.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Domicilio extends Base{

    private String calle;
    private int numero;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="localidad_id")
    private Localidad localidad;
}
