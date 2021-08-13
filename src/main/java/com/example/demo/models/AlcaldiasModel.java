package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "alcaldia")
public class AlcaldiasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombre;
    

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
}
