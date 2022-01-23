package com.coaching.backend.service;

import com.coaching.backend.exception.UserNotFoundException;
import com.coaching.backend.model.Client;
import com.coaching.backend.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService{
    protected ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllUsers(){
        return clientRepository.findAll();
    }

    public Client getUserWithId(long id) {
        return clientRepository.findById(id).orElseThrow( () ->  new UserNotFoundException(id));
    }

    public Client getUserWithEmail(String email) {
        return clientRepository.findByEmail(email).orElseThrow( () ->  new UserNotFoundException(email));
    }

    public List<Client> getUsersWithName(String first_name, String last_name) {
        return clientRepository.findByFirstNameAndLastName(first_name, last_name);
    }
}