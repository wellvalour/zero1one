package com.gruppezwei.zero1one.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private String name;
	
	private String passwort;
	
	private int berechtigungsID;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	
	public String getPasswort() {
		return passwort;
	}
	
	public void setBerechtigungsID(int berechtigungsID) {
		this.berechtigungsID = berechtigungsID;
	}
	
	public int getBerechtigungsID() {
		return berechtigungsID;
	}
	
}
