package com.gruppezwei.zero1one.controller;

import java.util.List;

public class Hilfsobjekt {

	private String recordName;

	private String CiType;

	private List<Attributtypen> typen;
	
	private List<Attribute> type;

	public String getRecordName() {
		return recordName;
	}

	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}
	
	public String getCiType() {
		return CiType;
	}

	public void setCiType(String ciType) {
		CiType = ciType;
	}
	
	public List<Attributtypen> getTypen() {
		return typen;
	}

	public void setTypen(List<Attributtypen> typen) {
		this.typen = typen;
	}

	public List<Attribute> getType() {
		return type;
	}

	public void setType(List<Attribute> type) {
		this.type = type;
	}
	
	
}
