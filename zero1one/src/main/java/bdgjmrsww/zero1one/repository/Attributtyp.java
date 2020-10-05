package bdgjmrsww.zero1one.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Attributtyp {

	@Id
	private String name;
	
	private String configItemTypname;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getConfigItemTypname() {
		return configItemTypname;
	}

	public void setConfigItemTypname(String configItemTypname) {
		this.configItemTypname = configItemTypname;
	}
	
}
