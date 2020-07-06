package com.app.country.controllers;

import com.app.AppFacade;
import com.app.country.model.Country;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/country")
public class CountryController {

    private final AppFacade appFacade;

    @PostMapping
    public Country createCountry(@RequestBody Country country) {
        return appFacade.createCountry(country);
    }
}
