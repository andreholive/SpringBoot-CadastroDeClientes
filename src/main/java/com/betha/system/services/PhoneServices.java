package com.betha.system.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betha.system.dto.PhoneDTO;
import com.betha.system.entities.Client;
import com.betha.system.entities.Phone;
import com.betha.system.repositories.PhoneRepository;
import com.betha.system.services.exceptions.ResourceNotFoundException;


@Service
public class PhoneServices {
	
	@Autowired
	private PhoneRepository repository;
	
	@Autowired
	private ClientServices clientServices;
	
	public Phone findById(Long id) {
		Optional<Phone> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Phone fromDto(PhoneDTO obj) {
		Client client = clientServices.findById(obj.getClient());
		Phone phone = new Phone(null, obj.getNumber(), obj.getInfo(), client);
		return phone;
	}
	
	public void savePhonesToNewClient(List<PhoneDTO> phoneList, Client client){
		phoneList.forEach(phone -> {
			Phone phoneObj = new Phone(null, phone.getNumber(), phone.getInfo(), client);
			insert(phoneObj);
		});
	}
	
	public Phone insert(Phone obj) {
		return repository.save(obj);
	}
}
