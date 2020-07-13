package com.app.country.controllers;

import com.app.AppFacade;
import com.app.country.models.Country;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/country")
public class CountryController {

    private final AppFacade appFacade;

    @PostMapping
    public Country createCountry(@RequestBody Country country) {
        return appFacade.createCountry(country);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCountryById(@PathVariable Long id) {
        appFacade.deleteCountry(id);
    }
}
