package com.example.zoo.domain;

public abstract class Animal {
    protected int legs;

	public Animal(int legs) {
		this.legs = legs;
	}
    
	public void walk() { // Concrete
		System.out.println("Animal with %d legs is running now...".formatted(this.legs));
	}
	
	public abstract void eat(); // abstract
}
