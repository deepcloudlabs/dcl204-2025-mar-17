package com.example.exercises;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;

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
		var highPopulatedCityOfEachContinent = countryDao.findAllCountries().stream()
				.map(country -> country.getCities().stream()
				.map(city -> new ContinentCityPair(country.getContinent(), city)).toList())
				.flatMap(Collection::stream)
				.collect(groupingBy(ContinentCityPair::continent,maxBy(ContinentCityPair::compareTo)));
		highPopulatedCityOfEachContinent.forEach(ContinentCityPair::printEntry);
	}

}

record ContinentCityPair(String continent, City city) {
	public int compareTo(ContinentCityPair other) {
		return this.city.getPopulation() - other.city.getPopulation();
	}

	public static void printEntry(String continent, Optional<ContinentCityPair> pair) {
		System.out.printf("%s: %s\n", continent, pair.get().city());
	}
}