package com.example.demo.controller;
import com.example.demo.services.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonArray;
import com.example.demo.models.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.awt.PageAttributes.MediaType;
import java.net.http.HttpHeaders;
import java.util.*;



@RestController
@RequestMapping("/alcaldias")
public class AlcaldiaController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    AlcaldiaService alcaldiaService;
@GetMapping()

    public ArrayList<AlcaldiasModel> obtenerAlcaldias(){
        return alcaldiaService.obtenerAlcaldias();
    }

    
    @PostMapping()
    public AlcaldiasModel guardarAlcaldia(@RequestBody AlcaldiasModel alcaldia){
        return this.alcaldiaService.guardarAlcaldia(alcaldia);
    }

    /*@GetMapping("/query")
    public ArrayList<AlcaldiasModel> obtenerAlcaldiaPorNombre(@RequestParam("nombre") String nombre) {
        return this.alcaldiaService.obtenerAlcaldiaNombre(nombre);
    }*/
    

    @GetMapping("/query2")
    public String mostrarResultado(@RequestParam("id") String id){
        String url ="https://datos.cdmx.gob.mx/api/3/action/datastore_search?resource_id=e4a9b05f-c480-45fb-a62c-6d4e39c5180e&q="+id;
            return restTemplate.getForObject(url,  String.class);
    }
    
    @GetMapping("/")
    public String mostrarResultado(){
        String url ="https://datos.cdmx.gob.mx/api/3/action/datastore_search?resource_id=e4a9b05f-c480-45fb-a62c-6d4e39c5180e";
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
    	 AlcaldiasModel alcaldia = new AlcaldiasModel();
    
    	 String name = objeto.getString("nomgeo");
    	 alcaldia.setNombre(name);
    	 guardarAlcaldia(alcaldia);
    	return  "Alcaldia:"+name;
    }
    
    
    
    
    

  

    

}
