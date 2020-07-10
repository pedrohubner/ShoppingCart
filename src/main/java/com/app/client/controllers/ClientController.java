package com.app.client.controllers;

import com.app.client.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/client")
@AllArgsConstructor
public class ClientController {

    private ClientService clientService;
}
