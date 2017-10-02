package io.javabrains.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Partei {

	@Id 
	long ID;
	String Name;
	String Prozent;
	Double AnzahlErst;
	Double StimmenanteilErst;
	Double StimmenanteilZweit;
	public Double getStimmenanteilZweit() {
		return StimmenanteilZweit;
	}
	public void setStimmenanteilZweit(Double stimmenanteilZweit) {
		StimmenanteilZweit = stimmenanteilZweit;
	}
	Double AnzahlZweit;
	
	public Double getAnzahlZweit() {
		return AnzahlZweit;
	}
	public void setAnzahlZweit(Double anzahlZweit) {
		AnzahlZweit = anzahlZweit;
	}
	public Double getStimmenanteilErst() {
		return StimmenanteilErst;
	}
	public void setStimmenanteilErst(Double stimmenanteilErst) {
		StimmenanteilErst = stimmenanteilErst;
	}
	public Double getAnzahlErst() {
		return AnzahlErst;
	}
	public void setAnzahlErst(Double anzahlErst) {
		AnzahlErst = anzahlErst;
	}
	public Partei() {}
	public Partei(long id,String name,String prozent) {
		this.setID(id);
		this.setName(name);
		this.setProzent(prozent);
	}
	
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getProzent() {
		return Prozent;
	}
	public void setProzent(String prozent) {
		Prozent = prozent;
	}
	
}
