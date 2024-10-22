package com.example.BmwBack.controllers;


import com.example.BmwBack.entities.Client;
import com.example.BmwBack.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Map;

@RestController
@RequestMapping("/bmwback")
public class BmwBackController {

    @Autowired
    private ClientRepository clientRepository;


    @GetMapping("/check-number")
    public ResponseEntity<Map<String, Boolean>> checkNumber(@RequestParam String number) {




        // Utiliser findByNumber pour vérifier si le client existe
        Client client = clientRepository.findByNumber(number);

        // Vérifier si le client est null
        boolean exists = (client != null);


        // Retourner la réponse avec le booléen
        return ResponseEntity.ok(Map.of("exists", exists));
    }


}



