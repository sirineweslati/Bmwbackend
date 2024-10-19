package com.example.BmwBack.controllers;

import com.example.BmwBack.repositories.ClientRepository;
import com.example.BmwBack.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    // Ajouter un client
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    // Afficher la liste des clients
    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Modifier un client
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client non trouvé"));
        client.setNumber(clientDetails.getNumber());
        client.setEmail(clientDetails.getEmail());
        final Client updatedClient = clientRepository.save(client);
        return ResponseEntity.ok(updatedClient);
    }

    // Supprimer un client
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client non trouvé"));
        clientRepository.delete(client);
        return ResponseEntity.noContent().build();
    }
}
