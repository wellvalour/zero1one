package bdgjmrsww.zero1one.controller;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ConfigItemErgebnis {
	
	@XmlElement(name="CI-Typ")
	private String configtyp;
	
	@XmlElement(name="Attribut")
	private List<ItemAttribut> attribute;
	
	
	public List<ItemAttribut> getAttribute() {
		return attribute;
	}
	
	public String getConfigtyp() {
		return configtyp;
	}
	
	public void setAttribute(List<ItemAttribut> attribute) {
		this.attribute = attribute;
	}
	
	public void setConfigtyp(String configtyp) {
		this.configtyp = configtyp;
	}
	
}
