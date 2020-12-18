package com.betha.system.dto;

import java.io.Serializable;

import com.betha.system.entities.Phone;

public class PhoneDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String number;
	private String info;
	private Long client;
	
	public PhoneDTO() {
		
	}
	
	public PhoneDTO(Phone phone) {
		id = phone.getId();
		number = phone.getNumber();
		info = phone.getInfo();
		client = phone.getClient().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Long getClient() {
		return client;
	}

	public void setClient(Long client) {
		this.client = client;
	}
	
	
}
