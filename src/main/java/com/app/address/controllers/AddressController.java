package com.app.address.controllers;

import com.app.AppFacade;
import com.app.address.models.Address;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/address")
@AllArgsConstructor
public class AddressController {

    private final AppFacade appFacade;

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return appFacade.createAddress(address);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAddressById(@PathVariable Long id) {
        appFacade.deleteAddress(id);
    }
}
