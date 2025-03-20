package com.example;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class StudySet {

	public static void main(String[] args) {
		// Set: i. unordered 
		//          x get(i),x sort
		//      ii. unique
        // Set<Integer> numbers = new HashSet<>();
        // Set<Integer> numbers = new LinkedHashSet<>();
        Set<Integer> numbers = new TreeSet<>((x,y)->y-x);
        numbers.add(4);
        numbers.add(42);
        numbers.add(4);
        numbers.add(8);
        numbers.add(23);
        numbers.add(16);
        numbers.add(15);
        numbers.add(4);
        numbers.add(42);
        System.out.println(numbers.contains(15)); // true
        Set<Customer> customers = new HashSet<>();
        customers.add(new Customer("1", "Jack Bauer"));
        System.out.println(customers.contains(new Customer("2", "Kate Austen"))); // false
        System.out.println(customers.contains(new Customer("1", "Jack Bauer"))); // true
        for (var number : numbers) {
        	System.out.println(number);
        }      
	}

}

record Customer(String identity,String fullName) {}