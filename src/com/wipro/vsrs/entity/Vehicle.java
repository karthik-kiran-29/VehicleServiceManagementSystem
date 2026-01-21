package com.wipro.vsrs.entity;

public class Vehicle {
	private String  vehicleId;
	private String ownerName;
	private String model;
	
	public Vehicle(String vehicleId, String ownerName, String model) {
		super();
		this.vehicleId = vehicleId;
		this.ownerName = ownerName;
		this.model = model;
	}
	
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", ownerName=" + ownerName + ", model=" + model + "]";
	}

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
}
