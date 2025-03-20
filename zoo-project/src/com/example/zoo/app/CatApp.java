package com.example.zoo.app;

import java.lang.reflect.Proxy;
import java.util.List;

import com.example.zoo.aspect.ProfilingAspect;
import com.example.zoo.domain.Cat;
import com.example.zoo.domain.Fish;
import com.example.zoo.domain.Pet;

public class CatApp {

	public static void main(String[] args) {
		var petAnimals = List.of(
				new Cat("Garfield"),
				new Fish("Jaws"),
				new Cat(),
				new Fish("Free Willy")
		);
		var petProxies = petAnimals.stream().map(CatApp::createProxyPet).toList();
		petAnimals.stream().map(Object::getClass).forEach(System.out::println);
		petProxies.stream().map(Object::getClass).forEach(System.out::println);
		petProxies.forEach(Pet::play);
		petAnimals.forEach(Pet::play);
	}

	public static Pet createProxyPet(Pet pet) {
		return (Pet) Proxy.newProxyInstance(
				pet.getClass().getClassLoader(), 
				pet.getClass().getInterfaces(), 
				new ProfilingAspect(pet)
		);
	}
}
