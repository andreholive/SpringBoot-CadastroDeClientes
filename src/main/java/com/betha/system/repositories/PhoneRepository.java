package com.betha.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betha.system.entities.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long>{

}