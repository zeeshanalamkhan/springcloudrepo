package com.nareshit.service;

import java.util.List;

import com.nareshit.bean.PatientBean;

public interface PatientService {

	public PatientBean createPatient(PatientBean patBean);
	public PatientBean  updatePatient(PatientBean patBean);
	public PatientBean   getPatientByid(int patId);
	public List<PatientBean> getAllPatients();
	public List<PatientBean> getAllPatients(int currPage,int noOfRecPerPage);
	public boolean deletePatient(int patId);
	public List<PatientBean> SearcgAllPatientsByName(String name);
}
