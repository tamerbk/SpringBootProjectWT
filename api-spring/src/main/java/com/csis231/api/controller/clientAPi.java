package com.csis231.api.controller;


import com.csis231.api.model.Client;
import com.csis231.api.repository.ClientRepsitory;
import com.csis231.api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/Client")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class clientAPi {

    @Autowired
    private ClientService clientService;
    public clientAPi(ClientService clientService){this.clientService=clientService;}


    @GetMapping("/search")
    public ResponseEntity<Long> searchClient(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {

        Long clientId = clientService.searchClient(username, password);

        if (clientId != null) {
            return ResponseEntity.ok(clientId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client createdClient = clientService.createClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
    }



}
