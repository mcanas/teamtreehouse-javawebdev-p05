package com.teamtreehouse.countries.model;

import java.util.Set;
import java.util.TreeSet;

public class Country {
    private String name;
    private String capital;
    private int population;
    private Set<String> languages;

    public Country(String name, String capital, int population, TreeSet<String> languages) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Set<String> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<String> languages) {
        this.languages = languages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (getPopulation() != country.getPopulation()) return false;
        if (!getName().equals(country.getName())) return false;
        if (!getCapital().equals(country.getCapital())) return false;
        return getLanguages().equals(country.getLanguages());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getCapital().hashCode();
        result = 31 * result + getPopulation();
        result = 31 * result + getLanguages().hashCode();
        return result;
    }
}
