package com.betha.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betha.system.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>, ClientRepositoryCustom{
	
}