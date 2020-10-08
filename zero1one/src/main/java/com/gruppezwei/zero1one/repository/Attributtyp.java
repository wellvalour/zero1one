package com.gruppezwei.zero1one.repository;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Attributtyp {

	@Id
	private String name;
	
	private String configitemtypname;
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getConfigItemTypname() {
		return configitemtypname;
	}

	public void setConfigItemTypname(String configItemTypname) {
		this.configitemtypname = configItemTypname;
	}
	
}
