package com.gruppezwei.zero1one.controller;

public class Attribute {
	
	private int id;

	private String attributtyp;

	private String wert;
	
	private int ciRecordId;

	
	public int getCiRecordId() {
		return ciRecordId;
	}

	public void setCiRecordId(int ciRecordId) {
		this.ciRecordId = ciRecordId;
	}

	public String getWert() {
		return wert;
	}

	public void setWert(String wert) {
		this.wert = wert;
	}
	public String getAttributtyp() {
		return attributtyp;
	}
	
	public void setAttributtyp(String attributtyp) {
		this.attributtyp = attributtyp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
