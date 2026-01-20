package com.wipro.vsrs.service;

import java.util.ArrayList;

import com.wipro.vsrs.entity.ServiceRecord;
import com.wipro.vsrs.entity.Vehicle;
import com.wipro.vsrs.util.VehicleNotFoundException;

public class VehicleServiceRecordService {
	private ArrayList<Vehicle> vechiles;
	private ArrayList<ServiceRecord> services;
	
	public VehicleServiceRecordService(ArrayList<Vehicle> vechiles, ArrayList<ServiceRecord> services) {
		this.vechiles = vechiles;
		this.services = services;
	}
	
	public void  addVehicle(Vehicle v) {
		this.vechiles.add(v);
	}
	
	public Vehicle findVehicle(String vehicleId) throws VehicleNotFoundException{
		try {
			for (Vehicle vechile :this.vechiles){
				if(vechile.getVehicleId()==vehicleId) {
					return vechile;
				}
			}
		}catch(VehicleNotFoundException e) {
			
		}
		
		throw new 
	}
	
}
