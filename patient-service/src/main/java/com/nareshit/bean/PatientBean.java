package com.nareshit.bean;

import com.google.gson.Gson;


public class PatientBean{

	private int id;
	private String fname;
	private String lname;
	private String createdDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	@Override
	public String toString() {
		Gson gson = new Gson();
		PatientBean patBean = new PatientBean();
		patBean.setId(id);
		patBean.setFname(fname);
		patBean.setLname(lname);
		patBean.setCreatedDate(createdDate);
		return gson.toJson(patBean);
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
