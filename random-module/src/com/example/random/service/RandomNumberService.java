package com.example.random.service;

import java.util.List;
import java.util.stream.IntStream;

public interface RandomNumberService {
	int generate(int min, int max);

	default List<Integer> generate(int min, int max, int size){
		return IntStream.range(0, size).mapToObj(i -> generate(min,max)).toList();
	}

}
