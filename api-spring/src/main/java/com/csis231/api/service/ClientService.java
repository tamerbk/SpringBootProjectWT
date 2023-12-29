package com.csis231.api.service;

import com.csis231.api.exception.ResourceNotFoundException;
import com.csis231.api.model.Client;
import com.csis231.api.repository.ClientRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepsitory clientRepsitory;

    public Client getClientById(long id)
    {
        return clientRepsitory.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Client not found"));
    }


    public Client createClient(Client client){
        return clientRepsitory.save(client);
    }

    public Long searchClient(String username, String password)
    {
        Client client = clientRepsitory.findByUsernameAndPassword(username,password);
        return client!=null?client.getId():null;
    }




}
