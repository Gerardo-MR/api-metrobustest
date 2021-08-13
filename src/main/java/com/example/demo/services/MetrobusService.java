package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.*;
import com.example.demo.repositories.*;

@Service
public class MetrobusService {	
	 @Autowired
	 MetrobusRepository metrobusRepository;
	 
    public ArrayList<MetrobusModel> obteneIdentificador(String identificador){
        return metrobusRepository.findByIdentificador(identificador);
    }

    public Optional<MetrobusModel> obtenerPorId(Long id){
        return metrobusRepository.findById(id);
    }

    public ArrayList<MetrobusModel> obtenerListadoMetrobus(){
        return (ArrayList<MetrobusModel>) metrobusRepository.findAll();
    }

    public MetrobusModel guardarMetrobus(MetrobusModel metrobus){
        return metrobusRepository.save(metrobus);
    }
    
}
