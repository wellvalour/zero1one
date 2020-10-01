package bdgjmrsww.zero1one.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mitarbeiter {

	@Id
	private int persnr;
	
	private String nachname;
	
	private String beruf;
	
	private String vorname;
	
	private double gehalt;
	
	public String getBeruf() {
		return beruf;
	}
	
	public String getNachname() {
		return nachname;
	}
	
	public int getPersnr() {
		return persnr;
	}
	
	public double getGehalt() {
		return gehalt;
	}
	
	public String getVorname() {
		return vorname;
	}
	
	public void setGehalt(double gehalt) {
		this.gehalt = gehalt;
	}
	
	public void setVorname(String vorname) {
		this.vorname = vorname;
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
