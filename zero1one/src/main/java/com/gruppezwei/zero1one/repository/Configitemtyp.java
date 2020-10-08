package com.gruppezwei.zero1one.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Configitemtyp {

	@Id
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
