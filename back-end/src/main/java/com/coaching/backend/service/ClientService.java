package com.coaching.backend.service;

import com.coaching.backend.model.Client;
import com.coaching.backend.model.DietPlan;
import com.coaching.backend.repository.ClientRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientService extends UserService<Client>{

    ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        super(clientRepository);
        this.clientRepository = clientRepository;
    }

    public List<DietPlan> getDietPlans() {
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return clientRepository.findByEmail(email).get().getDietPlans();
    }
}