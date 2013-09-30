package com.techtrend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techtrend.dataaccess.VehicleDao;
import com.techtrend.domain.Vehicle;


@Repository
public class VehicleServiceImpl implements VehicleService{
	
	private final VehicleDao vehicleDao;
	
	@Autowired
	public VehicleServiceImpl(VehicleDao vehicleDao){
		
        if (vehicleDao == null) {
            throw new IllegalArgumentException("vehicleDao cannot be null");
        }

        this.vehicleDao = vehicleDao;
		
	}

	@Override
	public void createVehicle(Vehicle vehicle) {
		vehicleDao.insert(vehicle);
		
	}

	@Override
	public Vehicle findVehicleById(String id) {
		return vehicleDao.findVehicleById(id);
	}
	

	@Override
	public List<Vehicle> getVehicles() {
		return vehicleDao.getVehicles();
	}


}
