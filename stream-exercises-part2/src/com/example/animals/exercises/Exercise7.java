package com.example.animals.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.animals.domain.Animal;
import com.example.animals.domain.Cat;
import com.example.animals.domain.Fish;
import com.example.animals.domain.Spider;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise7 {
	public static void main(String[] args) {
		// Count the number of animals in each specie 
		List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Willy"),
				new Spider(), new Fish("Jaws"));
		animals.stream()
		       .collect(Collectors.groupingBy(Object::getClass, Collectors.counting()))
		       .forEach((clazz,count) -> System.out.println("%s: %d".formatted(clazz.getSimpleName(),count)));
	}
}
