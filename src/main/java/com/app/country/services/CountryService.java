package com.app.country.services;

import com.app.country.model.Country;
import com.app.country.repositories.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }
}
