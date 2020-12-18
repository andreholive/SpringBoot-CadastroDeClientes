package com.betha.system.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{

	@Id
	private String role_name;

	@ManyToMany(mappedBy = "roles")
    private List<Usuario> users;
	
		
	

	public String getRole_name() {
		return role_name;
	}




	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}




	public List<Usuario> getUsers() {
		return users;
	}




	public void setUsers(List<Usuario> users) {
		this.users = users;
	}




	@Override
	public String getAuthority() {
		return this.role_name;
	}
	
	
}