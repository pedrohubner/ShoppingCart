package com.app.adress.controllers;

import com.app.AppFacade;
import com.app.adress.models.Address;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/address")
public class AddressController {

    private final AppFacade appFacade;

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return appFacade.createAddress(address);
    }
}
