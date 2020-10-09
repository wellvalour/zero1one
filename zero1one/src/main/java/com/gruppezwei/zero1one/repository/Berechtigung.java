package com.gruppezwei.zero1one.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Berechtigung {
	
	@Id
	private int id;
	
	private String bezeichnung;
	
	public int getID() {
		return id;
	}
	
	public void setID(int iD) {
		id = iD;
	}
	
	public String getBezeichnung() {
		return bezeichnung;
	}
	
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
}
