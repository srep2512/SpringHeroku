package io.javabrains.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Todo {
	
	@Id
	int ID;
	String Name;
	
	public Todo(){}
	public Todo(int id, String name) {
		this.setID(id);
		this.setName(name);
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}

}
