package com.nareshit.bean;


public class DoctorBean{

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
		return "DoctorBean [id=" + id + ", fname=" + fname + ", lname=" + lname + ", createdDate=" + createdDate + "]";
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
