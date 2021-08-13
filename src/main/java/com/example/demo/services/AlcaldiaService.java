package com.example.demo.services;

import com.example.demo.models.*;
import com.example.demo.repositories.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;



import java.util.ArrayList;
import java.util.Optional;

@Service
public class AlcaldiaService {
    @Autowired
    AlcaldiaRepository alcaldiaRepository;


    public ArrayList<AlcaldiasModel> obtenerAlcaldiaNombre(String alcaldia){
        return alcaldiaRepository.findByNombre(alcaldia);
    }

    public Optional<AlcaldiasModel> obtenerPorId(Long id){
        return alcaldiaRepository.findById(id);
    }

    public ArrayList<AlcaldiasModel> obtenerAlcaldias(){
        return (ArrayList<AlcaldiasModel>) alcaldiaRepository.findAll();
    }

    public AlcaldiasModel guardarAlcaldia(AlcaldiasModel alcaldia){
        return alcaldiaRepository.save(alcaldia);
    }
    
    
 
    
    

  
}
