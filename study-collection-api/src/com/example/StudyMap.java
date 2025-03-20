package com.example;

import java.util.HashMap;
import java.util.Map;

public class StudyMap {

	public static void main(String[] args) {
		// Pair: (Key,Value) Key -> Value
		// 1M 
		Map<String,Integer> areaCodes = new HashMap<>(2_000_000,0.5f);
		areaCodes.put("ankara", 312);
		areaCodes.put("izmir", 232);
		areaCodes.put("istanbul-anadolu", 216);
		areaCodes.put("istanbul-avrupa", 212);
		// Fastest: HashMap
		// LinkedHashMap: ekleme sırası
		// TreeMap: Key'ler sıralı
		System.out.println(areaCodes.get("istanbul-anadolu"));
        System.out.println(areaCodes.get("izmir"));
        // external loop over keys
        for (var city : areaCodes.keySet()) {
        	System.out.println(city);
        }
        // external loop over values
        for (var code : areaCodes.values()) {
        	System.out.println(code);
        }
        // external loop over entries
        for (var entry : areaCodes.entrySet()) {
        	System.out.println("%s: %d".formatted(entry.getKey(),entry.getValue()));
        }
        // internal loop over entries -> functional programming
        areaCodes.forEach((key,value) -> System.out.println("%s: %d".formatted(key,value)));
        
        
	}

}
