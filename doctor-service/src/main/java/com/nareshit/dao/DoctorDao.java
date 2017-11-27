package com.nareshit.dao;

import java.util.List;

import com.nareshit.domain.Doctor;



public interface DoctorDao {

	public Doctor saveDoctor(Doctor pat);
	public Doctor updateDoctor(Doctor pat);
	public boolean deleteDoctor(int id);
	public Doctor getDoctorById(int id);
	public Doctor getDoctorByName(String name);
	public List<Doctor> getAllDoctor();
	public List<Doctor> getAllDoctorsByPaging(int currPage,int noOfRecPerPage);
	public List<Doctor> searchAllDoctorsByName(String name);
}
