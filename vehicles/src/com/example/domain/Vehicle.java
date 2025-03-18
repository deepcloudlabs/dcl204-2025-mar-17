package com.example.domain;

public class Vehicle {
	// information hiding
    // attributes: maxLoad, currentLoad
	private double maxLoad; 
	private double currentLoad; 
	// methods: constructor, getter
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
	
	//          business methods: load(box), unload(box)
	//          toString
}
