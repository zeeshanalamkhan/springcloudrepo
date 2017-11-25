package com.nareshit.bean;



public class PatientBean{

	private int id;
	private String fname;
	private String lname;
	private String createdDate;
	private String doctorInfo;
	public String getDoctorInfo() {
		return doctorInfo;
	}
	public void setDoctorInfo(String doctorInfo) {
		this.doctorInfo = doctorInfo;
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
	
	@Override
	public String toString() {
		return "PatientBean [id=" + id + ", fname=" + fname + ", lname=" + lname + ", createdDate=" + createdDate
				+ ", doctorInfo=" + doctorInfo + "]";
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
