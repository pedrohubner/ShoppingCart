package com.app.address.controllers;

import com.app.address.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/address")
@AllArgsConstructor
public class AddressController {

    private AddressService addressService;
}
