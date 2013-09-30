package com.techtrend.service;

import java.util.List;

import com.techtrend.domain.Vehicle;



public interface VehicleService {
	
	void createVehicle(Vehicle vehicle);
	
	Vehicle findVehicleById(String id);
	
	
	List<Vehicle> getVehicles();


}
