package com.betha.system.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.betha.system.entities.Address;
import com.betha.system.entities.Client;
import com.betha.system.entities.Phone;
import com.betha.system.entities.Usuario;
import com.betha.system.repositories.AddressRepository;
import com.betha.system.repositories.ClientRepository;
import com.betha.system.repositories.PhoneRepository;
import com.betha.system.repositories.UserRepository;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(null, "andreolive@live.com", "$2a$10$NSmzFJ900GY6JLHdmbVhYuk/Bg6.q0jXiJxmxFR5iN97cC81/CCnW");
		Usuario u2 = new Usuario(null, "leila@gmail.com", "$2a$10$NSmzFJ900GY6JLHdmbVhYuk/Bg6.q0jXiJxmxFR5iN97cC81/CCnW");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		Client c1 = new Client(null, "04729685997", null, "André", u1);
		Client c2 = new Client(null, "04729685998", null, "Leila", u1);
		Client c3 = new Client(null, "04729685999", null, "Bernardo", u2);
		
		clientRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Address a1 = new Address(null, "Rua1", "Bairo X", "Cidade Y", "Estado Z", "88960000", true, c1);
		Address a2 = new Address(null, "Rua2", "Bairo Massa", "Cidade Top", "Estado Maneiro", "85670070", false, c1);
		
		addressRepository.saveAll(Arrays.asList(a1, a2));
		
		Phone p1 = new Phone(null, "48996902092", "celular", c1);
		
		phoneRepository.save(p1);
	}
	
	
}
