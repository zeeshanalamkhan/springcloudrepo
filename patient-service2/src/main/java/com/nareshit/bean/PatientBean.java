package com.nareshit.bean;

import com.google.gson.Gson;


public class PatientBean{

	private int id;
	private String fname;
	private String lname;
	private String createdDate;
	private String docInfo;
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
		return "PatientBean [id=" + id + ", fname=" + fname + ", lname=" + lname + ", createdDate=" + createdDate
				+ ", docInfo=" + docInfo + "]";
	}
	public String getDocInfo() {
		return docInfo;
	}
	public void setDocInfo(String docInfo) {
		this.docInfo = docInfo;
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
