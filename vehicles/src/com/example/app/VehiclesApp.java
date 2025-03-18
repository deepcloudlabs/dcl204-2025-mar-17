package com.example.app;

import com.example.domain.Vehicle;

// Ctrl + M 
public class VehiclesApp {

	public static void main(String[] args) {
		Vehicle firstVehicle = new Vehicle(1_000);
		Vehicle secondVehicle = new Vehicle(2_000,300);
		Vehicle thirdVehicle = new Vehicle();
		firstVehicle.load(500);
		firstVehicle.load(250);
		firstVehicle.load(300);
		System.out.println(firstVehicle);
		System.out.println(secondVehicle);
		System.out.println(thirdVehicle);
	}

}
