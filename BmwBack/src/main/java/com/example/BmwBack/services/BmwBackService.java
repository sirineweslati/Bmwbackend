package com.example.BmwBack.services;

import com.example.BmwBack.entities.Client;
import com.example.BmwBack.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BmwBackService {
    @Autowired
    private ClientRepository clientRepository;

    public boolean checkNumber( String number){
        // Utiliser findByNumber pour vérifier si le client existe
        Client client = clientRepository.findByNumber(number);
        // Vérifier si le client est null
        boolean exists = (client != null);
        return exists;
    }
}
