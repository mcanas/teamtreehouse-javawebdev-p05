package com.teamtreehouse.countries.controller;

import com.teamtreehouse.countries.data.CountryRepository;
import com.teamtreehouse.countries.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CountriesController {

    @Autowired
    private CountryRepository repo;

    @RequestMapping("/")
    public String home(ModelMap model,
                       @RequestParam(value = "sort_by", required = false) String sortBy) {

        List<Country> countries = repo.getAllCountries(sortBy);
        model.put("countries", countries);
        model.put("sort_by", sortBy);
        return "index";
    }

    @RequestMapping("/country/{name}")
    public String country(ModelMap model,
                          @PathVariable("name") String name) {

        Country country = repo.findByName(name);
        model.put("country", country);
        return "country";
    }
}
