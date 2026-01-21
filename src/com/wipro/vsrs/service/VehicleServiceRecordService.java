package com.wipro.vsrs.service;

import java.util.ArrayList;

import com.wipro.vsrs.entity.PartUsed;
import com.wipro.vsrs.entity.ServiceRecord;
import com.wipro.vsrs.entity.Vehicle;
import com.wipro.vsrs.util.InvalidServiceOperationException;
import com.wipro.vsrs.util.ServiceNotFoundException;
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
			for (Vehicle vechile :vechiles){
				if(vechile.getVehicleId().equals(vehicleId)) {
					return vechile;
				}
			}
			throw new VehicleNotFoundException("Vehicle with ID " + vehicleId + " not found");
	}
	
	public void addServiceRecord(ServiceRecord sr) throws VehicleNotFoundException,InvalidServiceOperationException{
		if(sr.getVehicleId().isEmpty()) {
			throw new VehicleNotFoundException("Vehicle with ID not found in ServiceRecord");
		}
		if(findVehicle(sr.getVehicleId())==null){
			throw new VehicleNotFoundException("Vehicle Not Exists");
		}
		double totalCost = 0;
		totalCost += sr.getTotalCost();
		for(PartUsed partUsed:sr.getPartsUsed()) {
			totalCost += partUsed.getCost();
		}
		if(totalCost <= 0) {
			throw new InvalidServiceOperationException("The Total Cost is less than or equal to Zero");
		}
		
		sr.setTotalCost(totalCost);
		
		this.services.add(sr);
	}
	
	public ServiceRecord findService(String serviceId) throws ServiceNotFoundException{
		for(ServiceRecord service:services) {
			if(service.getServiceId().equals(serviceId)) {
				return service;
			}
		}
		
		throw new ServiceNotFoundException("Invalid service Id");
	}
	
	private int  getIndexAndDelete(String serviceId) {
		int i = 0;
		
		for(ServiceRecord service:services) {
			if(service.getServiceId().equals(serviceId)) {
				services.remove(i);
				return i;
			}
			i++;
		}
		
		return -1;
	}
	
	public void updateServiceCharges(String serviceId, double newLaborCharges) throws ServiceNotFoundException,InvalidServiceOperationException{
		if(serviceId.isBlank()) {
			throw new InvalidServiceOperationException("The service Id is not given");
		}
		
		ServiceRecord tempSr = findService(serviceId);
		
		int tempIterator = getIndexAndDelete(serviceId);
		
		tempSr.setLaborCharges(newLaborCharges);
		
		this.services.add(tempIterator,tempSr);
	}
	
	public ArrayList<ServiceRecord> getServiceHistory(String vehicleId) throws VehicleNotFoundException{
		ArrayList<ServiceRecord> sr = new ArrayList<>();
		
		for(ServiceRecord service:services) {
			if(service.getVehicleId().equals(vehicleId)) {
				sr.add(service);
			}
		}
		
		if(sr.size()==0) {
			throw new VehicleNotFoundException("The Vehicle Id is invalid");
		}
		
		return sr;
	}
	
	public String generateServiceSummary(String vehicleId) throws VehicleNotFoundException{
		StringBuilder string = new StringBuilder();
		
		string.append("Vechiles Details: \n");
		
		for(Vehicle vechicle:vechiles) {
			string.append(vechicle.toString() + " \n");
		}
		
		string.append("Number of Services: "+ services.size() +"\n");
		
		string.append("Most recent Service: "+ services.getLast().getServiceDate() +"\n");
		
		int total = 0;
		
		for(ServiceRecord sr:services) {
			total+= sr.getTotalCost();
		}
		
		string.append("Total Amount Spend:" + total);
		
		
		
		
		return string.toString();
	}
	
	
	
}
