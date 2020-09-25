package bdgjmrsww.zero1one.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mitarbeiter {

	@Id
	private int persnr;
	
	private String nachname;
	
	private String beruf;
	
	
	public String getBeruf() {
		return beruf;
	}
	
	public String getNachname() {
		return nachname;
	}
	
	public int getPersnr() {
		return persnr;
	}
	
	public void setBeruf(String beruf) {
		this.beruf = beruf;
	}
	
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	public void setPersnr(int persnr) {
		this.persnr = persnr;
	}
}
