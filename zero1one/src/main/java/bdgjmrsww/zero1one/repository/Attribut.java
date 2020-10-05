package bdgjmrsww.zero1one.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Attribut {
	
	@Id
	private int configItemID;
	
	@Id
	private int attributtypID;
	
	private String wert;
	
	public int getConfigItemID() {
		return configItemID;
	}
	
	public void setConfigItemID(int configItemID) {
		this.configItemID = configItemID;
	}
	
	public int getAttributtypID() {
		return attributtypID;
	}
	
	public void setAttributtypID(int attributtypID) {
		this.attributtypID = attributtypID;
	}
	
	public String getWert() {
		return wert;
	}
	
	public void setWert(String wert) {
		this.wert = wert;
	}
}
