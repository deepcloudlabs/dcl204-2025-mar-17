package com.example.domain;

public class Vehicle {
	// information hiding
    // attributes: maxLoad, currentLoad
	private double maxLoad; 
	private double currentLoad; 
	// methods: constructor, getter
	/*
	public Vehicle() { // no-argument constructor
		this.maxLoad = 3_000.0;
		this.currentLoad = 0.0;
	}
	public Vehicle(double maxLoad) {
		this.maxLoad = maxLoad;
		this.currentLoad = 0.0;
	}
	public Vehicle(double maxLoad, double currentLoad) {
		this.maxLoad = maxLoad;
		this.currentLoad = currentLoad;
	}
	*/
	// binocular (dürbün) constructor
	public Vehicle() { // no-argument constructor
		this(3_000.0);
	}
	public Vehicle(double maxLoad) {
		this(maxLoad,0.0);
	}
	// all-argument constructor
	public Vehicle(double maxLoad, double currentLoad) {
		this.maxLoad = maxLoad;
		this.currentLoad = currentLoad;
	}
	public double getMaxLoad() {
		return maxLoad;
	}
	public double getCurrentLoad() {
		return currentLoad;
	}
	//          business methods: load(box), unload(box)
	public boolean load(double weight) {
		// validation
		if(weight <= 0.0) {
			return false;
		}
		// business rule
		if ((this.currentLoad+weight)>this.maxLoad) {
			return false;
		}
		// this.currentLoad = this.currentLoad + weight;
		this.currentLoad += weight;
		return true;
	}
	public boolean unload(double weight) {
		// validation
		if(weight <= 0.0) {
			return false;
		}
		// business rule
		if (weight > this.currentLoad) {
			return false;
		}
		this.currentLoad -= weight;
		return true;
	}
	//          toString
}
