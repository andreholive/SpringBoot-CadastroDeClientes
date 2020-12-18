package com.betha.system.resources;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.betha.system.dto.AddressDTO;
import com.betha.system.entities.Address;
import com.betha.system.services.AddressServices;
import com.betha.system.services.exceptions.DatabaseException;

@CrossOrigin(origins = "*", maxAge = 3600, methods = {
		RequestMethod.POST, 
		RequestMethod.GET,
		RequestMethod.PUT,
		RequestMethod.DELETE
})
@RestController
@RequestMapping(value = "/address")
public class AddressResources {
	
	@Autowired
	private AddressServices service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Address> findById(@PathVariable Long id){
		Address obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Address> insert(@RequestBody AddressDTO obj){
		Address addr = service.fromDto(obj);
		addr = service.insert(addr);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addr.getId()).toUri();
		return ResponseEntity.created(uri).body(addr);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Address> saveMainAddr(@RequestBody AddressDTO obj){
		Optional<Address> addr = service.update(obj);
		Address updatedAddress =  addr.orElseThrow(() -> new DatabaseException("Erro de Banco de Dados"));
		return ResponseEntity.ok().body(updatedAddress);
	}
}
