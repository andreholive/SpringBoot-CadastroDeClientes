package com.betha.system.dto;

import java.io.Serializable;
import java.util.List;
import com.betha.system.entities.Client;


public class ClientDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String cpf;
	private String cnpj;
	private String nome;
	private Long user;
	private List<PhoneDTO> phones;
	private List<AddressDTO> enderecos;
	
	public ClientDTO() {
		
	}
	
	public ClientDTO(Client client) {
		id = client.getId();
		cpf = client.getCpf();
		cnpj = client.getCnpj();
		nome = client.getNome();
		user = client.getUser().getId();
	}
	
	

	public List<AddressDTO> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<AddressDTO> enderecos) {
		this.enderecos = enderecos;
	}

	public List<PhoneDTO> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneDTO> phones) {
		this.phones = phones;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getUser() {
		return user;
	}

	public void setUser_id(Long user) {
		this.user = user;
	}
	
	
}
