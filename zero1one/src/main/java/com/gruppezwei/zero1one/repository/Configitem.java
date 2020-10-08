package com.gruppezwei.zero1one.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Configitem {
	
	@Id
	private int id;
	
	private String configitemtypname;
	
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConfigItemTypname() {
		return configitemtypname;
	}

	public void setConfigItemTypname(String configItemTypname) {
		this.configitemtypname = configItemTypname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
