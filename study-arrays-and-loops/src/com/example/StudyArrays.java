package com.example;

import java.util.Arrays;

public class StudyArrays {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int x = 42; // scalar
		int numbers[] = { 4, 8, 15, 16, 23, 42 }; // array
		int []dizi = { 4, 8, 15, 16, 23, 42 }; // array
        System.out.println(numbers.length);
        System.out.println(dizi[2]);
        System.out.println(dizi[5]);
        dizi[5]++;
        System.out.println(dizi[5]);
        int[] extendedArray = new int[2 * numbers.length];
        System.arraycopy(numbers, 0, extendedArray, 0, numbers.length);
        System.out.println(Arrays.toString(numbers));
        numbers = extendedArray; 
        System.out.println(Arrays.toString(numbers));
	}

}
