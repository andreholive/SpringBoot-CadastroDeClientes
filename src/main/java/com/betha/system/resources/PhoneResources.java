package com.betha.system.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.betha.system.dto.PhoneDTO;
import com.betha.system.entities.Phone;
import com.betha.system.services.PhoneServices;

@CrossOrigin(origins = "*", maxAge = 3600, methods = {
		RequestMethod.POST, 
		RequestMethod.GET,
		RequestMethod.PUT,
		RequestMethod.DELETE
})
@RestController
@RequestMapping(value = "/phone")
public class PhoneResources {
	
	@Autowired
	private PhoneServices service;
	
	@PostMapping
	public ResponseEntity<Phone> insert(@RequestBody PhoneDTO objDto){
		Phone phone = service.fromDto(objDto);
		phone = service.insert(phone);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(phone.getId()).toUri();
		return ResponseEntity.created(uri).body(phone);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Phone> findById(@PathVariable Long id){
		Phone obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
