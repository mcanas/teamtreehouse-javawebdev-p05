package com.teamtreehouse.countries.data;

import com.teamtreehouse.countries.model.Country;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

@Component
public class CountryRepository {
    private static final List<Country> ALL_COUNTRIES = Arrays.asList(
        new Country("Ecuador", "Quito", 16144000, new TreeSet<>(Arrays.asList(new String[]{"Spanish", "Kichwa", "Shuar"}))),
        new Country("France", "Paris", 66736000, new TreeSet<>(Arrays.asList(new String[]{"French"}))),
        new Country("India", "New Dehli", 1293057000, new TreeSet<>(Arrays.asList(new String[]{"Hindi", "English"}))),
        new Country("Italy", "Rome", 60674003, new TreeSet<>(Arrays.asList(new String[]{"Spanish"}))),
        new Country("Kenya", "Nairobi", 45010056, new TreeSet<>(Arrays.asList(new String[]{"English", "Kiswahili"})))
    );

    public List<Country> getAllCountries() {
        return ALL_COUNTRIES;
    }

    public Country findByName(String name) {
        Country country = getAllCountries().stream()
                            .filter(c->c.getName().toLowerCase().equals(name))
                            .findFirst()
                            .orElse(null);

        return country;
    }
}
