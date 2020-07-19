package com.app.client.controllers;

import com.app.AppFacade;
import com.app.client.models.Client;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/client")
@AllArgsConstructor
public class ClientController {

    private final AppFacade appFacade;

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return appFacade.createClient(client);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteClientById(@PathVariable Long id) {
        appFacade.deleteClient(id);
    }
}
