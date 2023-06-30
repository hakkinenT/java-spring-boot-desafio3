package com.hakkinenT.desafio3.controllers;

import com.hakkinenT.desafio3.dto.ClientDTO;
import com.hakkinenT.desafio3.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    @Autowired
    private ClientService service;

    @PostMapping
    public ClientDTO insert(@RequestBody ClientDTO dto){
        return service.insert(dto);
    }
}
