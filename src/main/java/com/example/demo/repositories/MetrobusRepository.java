package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.*;


public interface MetrobusRepository extends CrudRepository<MetrobusModel,Long> {
	public abstract ArrayList<MetrobusModel>findByIdentificador(String identificador);
}
