package com.betha.system.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.betha.system.dto.ClientDTO;
import com.betha.system.entities.Client;
import com.betha.system.entities.Usuario;
import com.betha.system.repositories.ClientRepository;
import com.betha.system.security.IAuthentication;
import com.betha.system.services.exceptions.DatabaseException;
import com.betha.system.services.exceptions.ResourceNotFoundException;


@Service
public class ClientServices {
	
	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private UserServices userServices;
	
	@Autowired
    private IAuthentication auth;
	
	@Autowired
	private UserServices userService;
	
	public Client findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Usuario getUser() {
		Usuario user = userService.findByUserName(auth.getUserName());
		return user;
	}
	
	public List<Client> findAll() {
		List<Client> obj = repository.findByUser(getUser());
		return obj;
	}
	
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	public Client fromDto(ClientDTO clientDTO) {
		Client client = new Client(clientDTO.getId(), clientDTO.getCpf(), clientDTO.getCnpj(), clientDTO.getNome(), getUser());
		return client;
	}
	
	public Client insert(Client obj) {
		List<Client> c = null;
		if(obj.getCpf() != null) {
			c = repository.findByCpfAndUser(obj.getCpf(), getUser());
		}else if(obj.getCnpj() != null) {
			c = repository.findByCnpjAndUser(obj.getCnpj(), getUser());
		}
		
		if(c.size() == 0) {
			return repository.save(obj);
		}
		return null;
	}
}
