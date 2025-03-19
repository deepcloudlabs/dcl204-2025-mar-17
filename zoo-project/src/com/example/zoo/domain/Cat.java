package com.example.zoo.domain;

public class Cat extends Animal implements Pet {
	private String name;

	public Cat() { // no-argument constructor
		this("Tekir");
	}

	public Cat(String name) {
		super(4);
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void play() {
		System.out.println("%s is playing now...".formatted(this.name));

	}

	@Override
	public void eat() {
		System.out.println("%s is eating now...".formatted(this.name));
	}

}
