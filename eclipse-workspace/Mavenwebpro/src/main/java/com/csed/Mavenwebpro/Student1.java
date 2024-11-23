package com.csed.Mavenwebpro;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Student1 {
	@Id
	private int rno;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrn() {
		return brn;
	}
	public void setBrn(String brn) {
		this.brn = brn;
	}
	private String name;
	private String brn;

}