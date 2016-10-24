package com.teamtreehouse.countries.data;

import com.teamtreehouse.countries.model.Country;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

@Component
public class CountryRepository {
    // Static repository of country classes
    private static final List<Country> ALL_COUNTRIES = Arrays.asList(
        new Country("Ecuador", "Quito", 16144000, new TreeSet<>(Arrays.asList(new String[]{"Spanish", "Kichwa", "Shuar"}))),
        new Country("France", "Paris", 66736000, new TreeSet<>(Arrays.asList(new String[]{"French"}))),
        new Country("India", "New Dehli", 1293057000, new TreeSet<>(Arrays.asList(new String[]{"Hindi", "English"}))),
        new Country("Italy", "Rome", 60674003, new TreeSet<>(Arrays.asList(new String[]{"Italian"}))),
        new Country("Kenya", "Nairobi", 45010056, new TreeSet<>(Arrays.asList(new String[]{"English", "Kiswahili"})))
    );

    // Get all countries, no sort order specified
    public List<Country> getAllCountries() {
        return ALL_COUNTRIES;
    }

    // Get all countries, with sort order
    public List<Country> getAllCountries(String sortBy) {
        List<Country> countries = getAllCountries();

        if(sortBy != null) {
            switch (sortBy) {
                case "name_desc": // Sorting by name descending
                    countries.sort((c1, c2) -> c2.getName().compareToIgnoreCase(c1.getName()));
                    break;
                case "population_asc": // Sorting by population ascending
                    countries.sort((c1, c2) -> Integer.compare(c1.getPopulation(), c2.getPopulation()));
                    break;
                case "population_desc": // Sorting by population descending
                    countries.sort((c1, c2) -> Integer.compare(c2.getPopulation(), c1.getPopulation()));
                    break;
                default: // Default sort order is by name, ascending
                    countries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
            }
        }

        return countries;
    }

    public Country findByName(String name) {
        // Find first country by name using lambda
        return getAllCountries().stream()
                .filter(c->c.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
