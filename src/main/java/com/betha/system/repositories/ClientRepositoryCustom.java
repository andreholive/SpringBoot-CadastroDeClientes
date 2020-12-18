package com.betha.system.repositories;

import java.util.List;

import com.betha.system.entities.Client;

public interface ClientRepositoryCustom {
	
	List<Client> findByCpf(String cpf);
	
	List<Client> findByCnpj(String cnpj);
}
