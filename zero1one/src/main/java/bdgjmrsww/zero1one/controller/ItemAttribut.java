package bdgjmrsww.zero1one.controller;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemAttribut {
	
	@XmlElement(name="Name")
	private String name;
	
	@XmlElement(name="Wert")
	private String wert;
	
	public ItemAttribut(String name, String wert) {
		this.name = name;
		this.wert = wert;
	}
	
	public String getName() {
		return name;
	}
	
	public String getWert() {
		return wert;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setWert(String wert) {
		this.wert = wert;
	}
}
