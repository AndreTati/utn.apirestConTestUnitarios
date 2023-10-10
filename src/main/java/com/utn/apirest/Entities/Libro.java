package com.utn.apirest.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro extends Base{
    private String titulo;
    private int fecha;
    private String genero;
    private int paginas;
    private String autor;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name="libro-autor",
    joinColumns = @JoinColumn(name="libro_id"),
    inverseJoinColumns = @JoinColumn(name="autor_id"))
    private List<Autor> autores=new ArrayList<>();

    public void setAutores(List<Autor> autores){
        this.autores=autores;
    }
}
