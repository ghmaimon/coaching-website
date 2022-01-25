package com.coaching.backend.service;

import com.coaching.backend.model.Client;
import com.coaching.backend.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends UserService<Client>{
    public ClientService(ClientRepository clientRepository) {
        super(clientRepository);
    }
}