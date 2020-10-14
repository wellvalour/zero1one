package com.gruppezwei.zero1one.controller;

import java.util.List;

public class CiRecord {

	private int id;
	
	private String name;
	
	private String ciTyp;
	
	private List<Attribute> attribute;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Attribute> getAttribute() {
		return attribute;
	}

	public void setAttribute(List<Attribute> attribute) {
		this.attribute = attribute;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getCiTyp() {
		return ciTyp;
	}

	public void setCiTyp(String ciTyp) {
		this.ciTyp = ciTyp;
	}
	
	
}
