package com.betha.system.repositories;

import java.util.List;

import com.betha.system.entities.Address;
import com.betha.system.entities.Client;

public interface AddressRepositoryCustom {
	
	List<Address> findByClient(Client client);
}
