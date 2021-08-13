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
	 
	 //Servicio  que perimte obtener desde la base de datos todos los datos del metrobus registrado por identificador
    public ArrayList<MetrobusModel> obteneIdentificador(String identificador){
        return metrobusRepository.findByIdentificador(identificador);
    }
    
    //Servicio  que perimte obtener desde la base de datos todos los datos del metrobus registrado por id
    public Optional<MetrobusModel> obtenerPorId(Long id){
        return metrobusRepository.findById(id);
    }
    //Servicio  que perimte obtener desde la base de datos todos los datos del metrobus 
    public ArrayList<MetrobusModel> obtenerListadoMetrobus(){
        return (ArrayList<MetrobusModel>) metrobusRepository.findAll();
    }
    
    // //Servicio  que perimte registrar datos de una unidad de metrobus segun sea consultada
    public MetrobusModel guardarMetrobus(MetrobusModel metrobus){
        return metrobusRepository.save(metrobus);
    }
    
}
