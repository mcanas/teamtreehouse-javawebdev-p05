package com.teamtreehouse.countries.data;

import com.teamtreehouse.countries.model.Country;
import com.teamtreehouse.countries.model.CountrySortBy;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

@Component
public class CountryRepository {
    // Static repository of country instances
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

    // Get all countries, with sort order specified
    public List<Country> getAllCountries(String sortBy) {
        List<Country> countries = getAllCountries();

        if(sortBy != null) {
            /**
             * Filter CountrySortBy enum by the sortBy value
             * to get the relevant comparator lambda
             */
            CountrySortBy c = Arrays.stream(CountrySortBy.values())
                                    .filter((v) -> v.getValue().equalsIgnoreCase(sortBy))
                                    .findFirst()
                                    .orElse(null);

            countries.sort(c.getComparator());
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
