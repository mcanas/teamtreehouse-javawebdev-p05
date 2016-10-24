package com.teamtreehouse.countries.model;

import java.util.Comparator;

/**
 * Enum for Country Sort By properties
 *  1. Name - A short descriptive name visible to the end user
 *  2. Value - the parameter value
 *  3. Comparator - the sort method
 */
public enum CountrySortBy {
    NAME_ASC(
        "Name Asc",
        "name_asc",
        (c1, c2)->c1.getName().compareToIgnoreCase(c2.getName())),
    NAME_DESC(
        "Name Desc",
        "name_desc",
        (c1, c2)->c2.getName().compareToIgnoreCase(c1.getName())),
    POPULATION_ASC(
        "Population Asc",
        "population_asc",
        (c1, c2) -> Integer.compare(c1.getPopulation(), c2.getPopulation())),
    POPULATION_DESC(
        "Population Desc",
        "population_desc",
        (c1, c2) -> Integer.compare(c2.getPopulation(), c1.getPopulation()));

    private final String name;
    private final String value;
    private final Comparator<Country> comparator;

    CountrySortBy(String name, String value, Comparator<Country> comparator) {
        this.name = name;
        this.value = value;
        this.comparator = comparator;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public Comparator<Country> getComparator() {
        return comparator;
    }
}
