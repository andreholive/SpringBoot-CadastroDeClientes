package com.betha.system.repositories;

import java.util.List;

import com.betha.system.entities.Client;
import com.betha.system.entities.Usuario;

public interface ClientRepositoryCustom {
	
	List<Client> findByCpfAndUser(String cpf, Usuario user);
	
	List<Client> findByCnpjAndUser(String cnpj, Usuario user);
	
	List<Client> findByUser(Usuario user);
}
