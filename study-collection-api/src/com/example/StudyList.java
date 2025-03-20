package com.example;

import java.util.LinkedList;
import java.util.List;

public class StudyList {

	public static void main(String[] args) {
		// List: i. ordered 
		//          get(i), sort
		//      ii. allows duplicates
        //List<Integer> numbers = new ArrayList<>(10_000_000);
        List<Integer> numbers = new LinkedList<>();
        var start = System.currentTimeMillis();
        for (var i=0;i<10_000_000;++i)
        	numbers.add(4);
        System.out.println(numbers.get(5_000_000));
        var stop = System.currentTimeMillis();
        System.out.println("%d: %d ms.".formatted(numbers.size(),(stop-start)));
        System.out.println(numbers.contains(15));
        for (var number : numbers) {
        	System.out.println(number);
        }
	}

}
