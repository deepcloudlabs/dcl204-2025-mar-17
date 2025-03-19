package com.example.zoo.app;

import java.util.Set;
import java.util.function.Consumer;

import com.example.zoo.domain.Animal;
import com.example.zoo.domain.Cat;
import com.example.zoo.domain.Fish;
import com.example.zoo.domain.Pet;
import com.example.zoo.domain.Spider;

public class ZooApp {

	public static void main(String[] args) {
		// List: Ordered, Allows Duplicates
		// Set : UnOrdered, Unique
		Set<Animal> zooAnimals = Set.of(new Spider(), new Cat(), new Fish("Free Willy"), new Cat("Garfield"),
				new Spider(), new Fish("Jaws"));
		// System.out.println(zooAnimals.get(4).getLegs());
		// System.out.println(zooAnimals.getFirst().getLegs());
		// System.out.println(zooAnimals.getLast().getLegs());
		
		// Imperative Programming
		for (var animal : zooAnimals) { // external loop
			animal.walk();
			animal.eat();
			if (animal instanceof Pet pet) {
				// var pet = (Pet) animal;
				pet.play();
			}
		}
		// Declarative Programming: functional programming -> Java SE 8
		Consumer<Animal> walk = Animal::walk;
		Consumer<Animal> eat = Animal::eat;
		Consumer<Animal> playIfPet = animal -> {
			if (animal instanceof Pet pet)
				pet.play();
		};
		zooAnimals.stream() // pipeline
				.parallel().sequential().forEach(walk.andThen(eat).andThen(playIfPet));
		// Imperative Programming
		var totalPetLegs = 0;
		for (var animal : zooAnimals) { // external loop
			if (animal instanceof Pet) {
				totalPetLegs += animal.getLegs();					
			}
		}
		System.out.println("Total number of Pet's legs: "+totalPetLegs);
		// Declarative Programming: Stream API -> Collection API
		totalPetLegs = zooAnimals.stream()
				                 .parallel()
				                 .filter(Pet.class::isInstance) // HoF
				                 .mapToInt(Animal::getLegs) // HoF
				                 .sum(); // reduce
		System.out.println("Total number of Pet's legs: "+totalPetLegs);
	}

}
