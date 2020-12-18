package com.betha.system.repositories;

import com.betha.system.entities.Usuario;

public interface UserRepositoryCustom {
	
	Usuario findByLogin(String login);
}
