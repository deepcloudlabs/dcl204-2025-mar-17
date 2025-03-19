package com.example.zoo.domain;

public abstract interface Pet {
	abstract String getName(); // public

	public void setName(String name); // abstract

	void play(); // public abstract
}
