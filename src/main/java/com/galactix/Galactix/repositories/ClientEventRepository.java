package com.galactix.Galactix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.galactix.Galactix.entities.ClientEvent;

public interface ClientEventRepository extends JpaRepository<ClientEvent, Long> {

}
