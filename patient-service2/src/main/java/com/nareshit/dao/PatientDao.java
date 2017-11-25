package com.nareshit.dao;

import java.util.List;

import com.nareshit.domain.Patient;

public interface PatientDao {

	public Patient savePatient(Patient pat);
	public Patient updatePatient(Patient pat);
	public boolean deletePatinet(int id);
	public Patient getPatientById(int id);
	public Iterable<Patient> getAllPatient();
	public List<Patient> getAllPatientsByPaging(int currPage,int noOfRecPerPage);
	public List<Patient> searchAllPatientsByName(String name);
}
