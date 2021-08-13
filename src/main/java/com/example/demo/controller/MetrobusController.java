package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.AlcaldiasModel;
import com.example.demo.models.MetrobusModel;
import com.example.demo.services.MetrobusService;

@RestController
@RequestMapping("/metrobus")
public class MetrobusController {
	 @Autowired
	 RestTemplate restTemplate;
	 MetrobusService metrobusService;
	 
	 //listado de metrobus en base interna 
	@GetMapping()
	    public ArrayList<MetrobusModel> obtenerListado(){
	        return metrobusService.obtenerListadoMetrobus();
	    }

	    //Insertar datos de metrobus por metodo post 
	    @PostMapping()
	    public MetrobusModel guardarUbicacion(@RequestBody MetrobusModel metrobus){
	        return this.metrobusService.guardarMetrobus(metrobus);
	    }
	    
	    
	    @GetMapping(path = "/{id}")
	    public Optional<MetrobusModel> obtenerMetrobusPorId(@PathVariable("id") Long id){
	        return this.metrobusService.obtenerPorId(id);
	    }

	    //Obtener datos desde api  por id 
	    @GetMapping("/search")
	    public String mostrarResultado(@RequestParam("id") String id){	    	
	        String url ="https://datos.cdmx.gob.mx/api/3/action/datastore_search?resource_id=ad360a0e-b42f-482c-af12-1fd72140032e&q="+id;
	        return restTemplate.getForObject(url,  String.class);
	    }
	    
	    
	    //Traer todos los datos desde api externa
	    @GetMapping("/")
	    public String mostrarResultados(){
	        String url ="https://datos.cdmx.gob.mx/api/3/action/datastore_search?resource_id=ad360a0e-b42f-482c-af12-1fd72140032e";
	        return  restTemplate.getForObject(url,  String.class);
	    }
	    
	    
	    //Mapear datos resividos desde api externa 
	    @GetMapping("/metrobus")	    
	    public MetrobusModel traer(@RequestParam("id") int idGet){
	    	 JSONObject json;
	    	
	    	String responseJson= mostrarResultados();	    	
	    	 json = new JSONObject(responseJson); 	
	    	 System.out.println(json);
	    	 
	    	JSONObject result = json.getJSONObject("result");
	    
	    	 JSONArray records = result.getJSONArray("records");
	    
	    	 JSONObject objeto = records.getJSONObject(idGet);
	    	 System.out.println(objeto.getInt("vehicle_id"));
	    
	    	 MetrobusModel metrobus = new MetrobusModel();
	    	
	         
	    	 int vehicle_id = objeto.getInt("vehicle_id");
	            String position_latitude =  objeto.getBigDecimal("position_latitude").toString();
	            String position_longitude = objeto.getBigDecimal("position_longitude").toString();
	            
	    	 metrobus.setVehicle_id(vehicle_id);
	    	 metrobus.setPosition_latitude(position_latitude);
	    	 metrobus.setPosition_longitude(position_longitude);	    	
	    	// guardarUbicacion(metrobus);
	    	 
	    	return metrobus;
	    }
}
