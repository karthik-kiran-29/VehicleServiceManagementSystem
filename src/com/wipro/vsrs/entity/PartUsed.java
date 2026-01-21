package com.wipro.vsrs.entity;

public class PartUsed {
	private String partName;
	private double cost;
	
	public PartUsed(String partName, double cost) {
		super();
		this.partName = partName;
		this.cost = cost;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	

}
