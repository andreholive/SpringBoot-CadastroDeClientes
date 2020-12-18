package com.betha.system.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.betha.system.dto.ClientDTO;
import com.betha.system.entities.Client;
import com.betha.system.services.AddressServices;
import com.betha.system.services.ClientServices;
import com.betha.system.services.PhoneServices;

@CrossOrigin(origins = "*", maxAge = 3600, methods = {
		RequestMethod.POST, 
		RequestMethod.GET,
		RequestMethod.PUT,
		RequestMethod.DELETE
})
@RestController
@RequestMapping(value = "/client")
public class ClientResources {
	
	@Autowired
	private ClientServices service;
	
	@Autowired
	private PhoneServices phoneService;
	
	@Autowired
	private AddressServices addressService;
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		List<Client> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Client> insert(@RequestBody ClientDTO objDTO){
		Client obj = service.fromDto(objDTO);
		obj = service.insert(obj);
		if(obj != null) {
			if(objDTO.getPhones().size() > 0) {
				phoneService.savePhonesToNewClient(objDTO.getPhones(), obj);
			}
			if(objDTO.getEnderecos().size() > 0) {
				addressService.saveAddressesToNewClient(objDTO.getEnderecos(), obj);
			}
			
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		}
		return ResponseEntity.badRequest().build();
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id){
		Client obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
