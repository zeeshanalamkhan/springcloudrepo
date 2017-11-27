package com.nareshit.bean;

import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DoctorBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4785332147957808413L;
	private int id;
	private String fname;
	private String lname;
	private String createdDate;
	@Override
	public String toString() {
		return "{id=" + id + ", fname=" + fname + ", lname=" + lname + ", createdDate=" + createdDate + "}";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
}
