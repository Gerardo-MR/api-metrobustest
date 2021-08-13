package com.example.demo.repositories;

import com.example.demo.models.*;

import org.springframework.data.repository.CrudRepository;



import java.util.ArrayList;


public interface AlcaldiaRepository extends CrudRepository<AlcaldiasModel,Long> {
    public abstract ArrayList<AlcaldiasModel>findByNombre(String nombre);
   

}
