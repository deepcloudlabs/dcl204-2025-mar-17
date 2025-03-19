package com.example.animals.exercises;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import com.example.animals.domain.Animal;
import com.example.animals.domain.Cat;
import com.example.animals.domain.Fish;
import com.example.animals.domain.Pet;
import com.example.animals.domain.Spider;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise1 {
	public static void main(String[] args) {
		// Take a list of wild animals
		List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Willy"),
				new Spider(), new Fish("Jaws"));
		// Functional Programming
		// function: i. Higher Order Function 
		//          ii. Pure Function: 1. Lambda Expression
		//                             2. Method Reference
		int x = 42;
		BigInteger y = new BigInteger("1000000000000000000000");
		Function<Integer, Boolean> even = number -> number%2 == 0; 
		/*
		Predicate<Animal> isPet = (Animal animal) -> {
			return animal instanceof Pet; 
		};
		*/
		Predicate<Animal> isPet = animal -> animal instanceof Pet;
		var isWild = isPet.negate();
		
		var wildAnimals = animals.stream()
		                         .filter(isWild)
		                         .toList();
		                    // lambda expression
		wildAnimals.forEach(animal -> System.out.println(animal));
					        // method reference
		wildAnimals.forEach(System.out::println);
	}
}
