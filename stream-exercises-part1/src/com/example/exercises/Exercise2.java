package com.example.exercises;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise2 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the most populated city of each continent
		Function<ContinentCity, Integer> populationExtractor = continentCity -> continentCity.city().getPopulation();
		var highPopCitiesByContinent =
		countryDao.findAllCountries()
		          .stream()                // Stream<Country>
		          .filter(country -> Objects.nonNull(country.getCities()))
		          .filter(country -> !country.getContinent().equals("Antarctica"))
		          .map(country -> new ContinentCity(country.getContinent(), country.getCities().stream().max(Comparator.comparingInt(City::getPopulation)).get())) // Stream<ContinentCities>
		          .collect(Collectors.groupingBy(ContinentCity::continent,Collectors.maxBy(Comparator.comparing(populationExtractor))));
		highPopCitiesByContinent.forEach((continent,continentCity) -> System.out.println("%16s: %32s".formatted(continent,continentCity.get().city().getName())));
	}

}

record ContinentCity(String continent,City city) {}