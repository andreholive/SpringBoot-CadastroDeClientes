package com.betha.system.dto;

import java.io.Serializable;

import com.betha.system.entities.Usuario;

public class UserDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String login;
	
	public UserDTO() {
		
	}
	public UserDTO(Usuario obj) {
		id = obj.getId();
		login = obj.getLogin();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	
	
}
