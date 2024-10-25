package com.aulasJava.DesafioCrudClientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulasJava.DesafioCrudClientes.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
