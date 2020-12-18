package com.betha.system.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betha.system.dto.UserDTO;
import com.betha.system.entities.Usuario;
import com.betha.system.repositories.UserRepository;
import com.betha.system.services.exceptions.ResourceNotFoundException;


@Service
public class UserServices {
	
	@Autowired
	private UserRepository repository;
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public List<Usuario> findAll() {
		List<Usuario> obj = repository.findAll();
		return obj;
	}
	
	public Usuario insert(Usuario obj) {
		return repository.save(obj);
	}
	
	public Usuario fromDTO(UserDTO objDto) {
		return null;
	}
}
