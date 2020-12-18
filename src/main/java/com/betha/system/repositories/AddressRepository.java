package com.betha.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betha.system.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>, AddressRepositoryCustom{

}