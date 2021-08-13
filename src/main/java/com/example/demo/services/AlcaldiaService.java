package com.example.demo.services;

import com.example.demo.models.*;
import com.example.demo.repositories.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.Optional;

@Service
public class AlcaldiaService {
    @Autowired
    AlcaldiaRepository alcaldiaRepository;

  //Servicio  que perimte obtener desde la base de datos todos los datos las alcaldias  registradas por nombre
    public ArrayList<AlcaldiasModel> obtenerAlcaldiaNombre(String alcaldia){
        return alcaldiaRepository.findByNombre(alcaldia);
    }
    //Servicio  que perimte obtener desde la base de datos todos los datos de las alcaldias registradas por id
    public Optional<AlcaldiasModel> obtenerPorId(Long id){
        return alcaldiaRepository.findById(id);
    }
    //Servicio  que perimte obtener desde la base de datos todos los datos de las alcaldias 
    public ArrayList<AlcaldiasModel> obtenerAlcaldias(){
        return (ArrayList<AlcaldiasModel>) alcaldiaRepository.findAll();
    }
 // //Servicio  que perimte registrar datos de una alcaldia segun sea consultada
    public AlcaldiasModel guardarAlcaldia(AlcaldiasModel alcaldia){
        return alcaldiaRepository.save(alcaldia);
    }
    
    
 
    
    

  
}
