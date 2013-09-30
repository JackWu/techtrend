package com.techtrend.dataaccess;

import com.techtrend.domain.Vehicle;

public interface VehicleDao {
	
	public int insert(Vehicle vehicle);
	public void update(Vehicle vehicle);
	public void delete(Vehicle vehicle);
	public Vehicle findByVehicleNo(String vehicleNo);

}
