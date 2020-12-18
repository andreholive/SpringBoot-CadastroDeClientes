package com.betha.system.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betha.system.dto.AddressDTO;
import com.betha.system.entities.Address;
import com.betha.system.entities.Client;
import com.betha.system.repositories.AddressRepository;
import com.betha.system.services.exceptions.ResourceNotFoundException;


@Service
public class AddressServices {
	
	@Autowired
	private AddressRepository repository;
	
	@Autowired
	private ClientServices clientServices;
	
	public Address findById(Long id) {
		Optional<Address> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Address fromDto(AddressDTO obj) {
		Client client = clientServices.findById(obj.getClient());
		Address addr = new Address(obj.getId(), obj.getRua(), obj.getBairro(), obj.getCidade(), obj.getEstado(), obj.getCep(), obj.isMain(), client);
		return addr;
	}
	
	public void saveAddressesToNewClient(List<AddressDTO> listAddress, Client client) {
		listAddress.forEach(address -> {
			Address addr = new Address(
					null, 
					address.getRua(), 
					address.getBairro(), 
					address.getCidade(), 
					address.getEstado(), 
					address.getCep(), 
					address.isMain(), 
					client);
			insert(addr);
		});
	}
	
	public boolean emptyAddress(Client client) {
		List<Address> list = repository.findByClient(client);
		if(list.size() == 0) {
			return true;
		}
		return false;
	}
	
	public Address insert(Address obj) {
		obj.setMain(emptyAddress(obj.getClient()));
		return repository.save(obj);
	}
	
	public void resetAllMainAddress(Client client) {
		List<Address> list = repository.findByClient(client);
		list.forEach(item -> {
			item.setMain(false);
			repository.save(item);
		});
	}
	
	public Optional<Address> update(AddressDTO obj) {
		Optional<Address> addr = repository.findById(obj.getId());
		addr.ifPresent(item -> {
			resetAllMainAddress(item.getClient());
			item.setMain(obj.isMain());
			repository.save(item);
		});
		return addr;
	}
}
