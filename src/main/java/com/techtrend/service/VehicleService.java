package com.techtrend.service;

import com.techtrend.domain.Vehicle;



public interface VehicleService {
	
	public void createVehicle(Vehicle vehicle);
	
	public Vehicle findVehicleByVehicleNo(String vehicleNo);


}
