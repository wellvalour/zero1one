package com.gruppezwei.zero1one.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Instanz {
	
	@Id
	private int id;
	
	private String instanztypname;
	
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstanzTypname() {
		return instanztypname;
	}

	public void setInstanzTypname(String instanzTypname) {
		this.instanztypname = instanzTypname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
