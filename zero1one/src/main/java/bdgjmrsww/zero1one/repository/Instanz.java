package bdgjmrsww.zero1one.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Instanz {
	
	@Id
	private int id;
	
	@Column(name = "ConfigItemTypname")
	private String configItemTypname;
	
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConfigItemTypname() {
		return configItemTypname;
	}

	public void setConfigItemTypname(String configItemTypname) {
		this.configItemTypname = configItemTypname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
