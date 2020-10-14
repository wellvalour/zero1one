package com.gruppezwei.zero1one.controller;

import java.util.List;

public class CiType {

	private String name;
	
	private List<Attributtypen> typen;
	
	
	
	public List<Attributtypen> getTypen() {
		return typen;
	}

	public void setTypen(List<Attributtypen> typen) {
		this.typen = typen;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
