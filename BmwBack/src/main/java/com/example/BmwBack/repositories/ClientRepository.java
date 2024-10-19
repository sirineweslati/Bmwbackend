package com.example.BmwBack.repositories;

import com.example.BmwBack.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByNumber(String number);
}
