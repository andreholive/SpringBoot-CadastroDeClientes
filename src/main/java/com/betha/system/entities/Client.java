package com.betha.system.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.betha.system.services.UserServices;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "clientes")
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	@Transient
	private UserServices services;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String cpf;
	
	private String cnpj;
	
	private String nome;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Usuario user;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Address> enderecos = new ArrayList<>();
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Phone> phones = new ArrayList<>();
	
	public Client() {
		
	}

	public Client(Long id, String cpf, String cnpj, String nome, Usuario user) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.nome = nome;
		this.user = user;
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
	
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
	
	public List<Address> getEnderecos() {
		return enderecos;
	}
	
	public List<Phone> getPhones() {
		return phones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
