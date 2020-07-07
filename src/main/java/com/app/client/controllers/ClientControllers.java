package com.app.client.controllers;

import com.app.AppFacade;
import com.app.client.models.Client;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/client")
public class ClientControllers {

    private final AppFacade appFacade;

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return appFacade.createClient(client);
    }
}
