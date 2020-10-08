package com.gruppezwei.zero1one.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Attribut {
	
	@Id
	private int id;
	
	private String configitemid;
	
	private String attributtypid;
	
	private String wert;
	
	public String getConfigItemID() {
		return configitemid;
	}
	
	public void setConfigItemID(String configItemID) {
		this.configitemid = configItemID;
	}
	
	public String getAttributtypID() {
		return attributtypid;
	}
	
	public void setAttributtypID(String attributtypID) {
		this.attributtypid = attributtypID;
	}
	
	public String getWert() {
		return wert;
	}
	
	public void setWert(String wert) {
		this.wert = wert;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
