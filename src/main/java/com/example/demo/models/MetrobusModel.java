package com.example.demo.models;

import javax.persistence.*;


@Entity
@Table(name = "metrobus")
public class MetrobusModel {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(unique = true, nullable = false)
	    private Long id;
	  
	   int vehicle_id;
	   String position_latitude;
	   String position_longitude;
	   String identificador;
	   
	   
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public String getPosition_latitude() {
		return position_latitude;
	}
	public void setPosition_latitude(String position_latitude) {
		this.position_latitude = position_latitude;
	}
	public String getPosition_longitude() {
		return position_longitude;
	}
	public void setPosition_longitude(String position_longitude) {
		this.position_longitude = position_longitude;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	   

	   

}
