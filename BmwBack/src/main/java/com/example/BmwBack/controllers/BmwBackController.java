package com.example.BmwBack.controllers;


import com.example.BmwBack.entities.Client;
import com.example.BmwBack.repositories.ClientRepository;
import com.example.BmwBack.services.BmwBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Map;

@RestController
@RequestMapping("/bmwback")
public class BmwBackController {
    @Autowired
    BmwBackService bmwBackService;

    @GetMapping("/check-number")
    public ResponseEntity<Map<String, Boolean>> checkNumber(@RequestParam String number) {
        boolean exists =bmwBackService.checkNumber(number) ;
        // Retourner la réponse avec le booléen
        return ResponseEntity.ok(Map.of("exists", exists));
    }


}



