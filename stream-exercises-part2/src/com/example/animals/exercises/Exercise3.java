package com.example.animals.exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.example.animals.domain.Animal;
import com.example.animals.domain.Cat;
import com.example.animals.domain.Fish;
import com.example.animals.domain.Spider;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise3 {
	public static void main(String[] args) {
		// Find the animal with the highest number of legs
		List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Willy"),
				new Spider(), new Fish("Jaws"));
		animals.stream()
		       .min(Comparator.comparingInt(Animal::getLegs))
		       .ifPresent(System.out::println);
	}
}
