package com.betha.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betha.system.entities.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long>, UserRepositoryCustom{

}