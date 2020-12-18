package com.betha.system.dto;

import java.io.Serializable;

import com.betha.system.entities.Address;

public class AddressDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private boolean main;
	private Long client;
	
	public AddressDTO() {
		
	}
	
	public AddressDTO(Address obj) {
		id = obj.getId();
		rua = obj.getRua();
		bairro = obj.getBairro();
		cidade = obj.getCidade();
		estado = obj.getEstado();
		cep = obj.getCep();
		main = obj.isMain();
		client = obj.getClient().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public boolean isMain() {
		return main;
	}

	public void setMain(boolean main) {
		this.main = main;
	}

	public Long getClient() {
		return client;
	}

	public void setClient(Long client) {
		this.client = client;
	}
	
	
	
	
}
