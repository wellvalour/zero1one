package bdgjmrsww.zero1one.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Berechtigung {
	
	@Id
	private int ID;
	
	private String bezeichnung;
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getBezeichnung() {
		return bezeichnung;
	}
	
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
}
