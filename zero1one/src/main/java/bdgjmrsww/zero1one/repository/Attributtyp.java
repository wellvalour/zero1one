package bdgjmrsww.zero1one.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Attributtyp {

	@Id
	private String name;
	
	private String configitemTypname;
}
