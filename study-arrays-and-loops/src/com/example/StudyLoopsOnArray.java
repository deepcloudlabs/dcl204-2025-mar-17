package com.example;

import java.util.Arrays;

public class StudyLoopsOnArray {

	public static void main(String[] args) {
		int numbers[] = { 4, 8, 15, 16, 23, 42 };

		// External Loop #1
		for (int i = 0; i < numbers.length; ++i) {
            System.out.println(numbers[i]); 
		}
        // External Loop #2
		int i=0;
		while (i < numbers.length) {
			System.out.println(numbers[i]); 
			++i;
		}
		// External Loop #3 since Java SE 5: for-each
		for (int number : numbers) {
			System.out.println(number); 			
		}
		// Internal Loop #4 since Java SE 8 -> functional programming
		System.out.println("number of cores: "+Runtime.getRuntime().availableProcessors());
		// data parallelism
		// -Djava.util.concurrent.ForkJoinPool.common.parallelism=128
		Arrays.stream(numbers).parallel().forEach(System.out::println);
	}

}
