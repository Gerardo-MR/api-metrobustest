package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	 
	@GetMapping("/list")

	    public ArrayList<MetrobusModel> obtenerListado(){
	        return metrobusService.obtenerListadoMetrobus();
	    }

	    
	    @PostMapping()
	    public MetrobusModel guardarUbicacion(@RequestBody MetrobusModel metrobus){
	        return this.metrobusService.guardarMetrobus(metrobus);
	    }


	    @GetMapping("/search")
	    public String mostrarResultado(@RequestParam("id") String id){
	    	
	        String url ="https://datos.cdmx.gob.mx/api/3/action/datastore_search?resource_id=ad360a0e-b42f-482c-af12-1fd72140032e&q="+id;
	        return restTemplate.getForObject(url,  String.class);
	    }
	    
	    @GetMapping("/")
	    public String mostrarResultado(){
	        String url ="https://datos.cdmx.gob.mx/api/3/action/datastore_search?resource_id=ad360a0e-b42f-482c-af12-1fd72140032e";
	        return  restTemplate.getForObject(url,  String.class);
	    }
	    
	    @GetMapping("/query")
	    public String traer(@RequestParam("id") int idGet){
	    	 JSONObject json;
	    	
	    	String responseJson= mostrarResultado();
	    	
	    	 json = new JSONObject(responseJson); 	
	    
	    	 JSONObject result = json.getJSONObject("result");
	    
	    	 JSONArray records = result.getJSONArray("records");
	    
	    	 JSONObject objeto = records.getJSONObject(idGet);
	    	 MetrobusModel metrobus = new MetrobusModel();
	    	 
	    	 int vehicle_id = Integer.parseInt( objeto.getString("vehicle_id"));
	    	 metrobus.setVehicle_id(vehicle_id);
	    	// guardarUbicacion(alcaldia);
	    	return  "Id del vehiculo:"+vehicle_id;
	    }
}
