package com.example.BmwBack.services;

import com.example.BmwBack.entities.Client;
import com.example.BmwBack.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public ResponseEntity<Client> updateClient( Long id, Client clientDetails) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client non trouvé"));
        client.setNumber(clientDetails.getNumber());
        client.setEmail(clientDetails.getEmail());
        final Client updatedClient = clientRepository.save(client);
        return ResponseEntity.ok(updatedClient);
    }

    public ResponseEntity<Void> deleteClient(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client non trouvé"));
        clientRepository.delete(client);
        return ResponseEntity.noContent().build();
    }
}
