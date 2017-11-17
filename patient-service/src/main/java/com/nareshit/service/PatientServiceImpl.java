package com.nareshit.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.nareshit.bean.PatientBean;
import com.nareshit.domain.Patient;

//@Repository
@Service
public class PatientServiceImpl implements PatientService {

	CrudRepository<Patient, Integer> repo;
	
	@Override
	public PatientBean createPatient(PatientBean patBean) {
		Patient pat = mapBeanToDomain(patBean);
		pat = repo.save(pat);
		return mapDomainToBean(pat);
	}

	@Override
	public PatientBean updatePatient(PatientBean patBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PatientBean getPatientByid(int patId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientBean> getAllPatients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientBean> getAllPatients(int currPage, int noOfRecPerPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePatient(int patId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PatientBean> SearcgAllPatientsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Patient mapBeanToDomain(PatientBean patBean) {
		Patient pat = new Patient();
		if(patBean.getId() >0) {
			pat.setPatId(patBean.getId());
		}
		if(patBean.getFname() != null && !patBean.getFname().isEmpty()) {
			pat.setFname(patBean.getFname());
		}
		if(patBean.getLname() != null && !patBean.getLname().isEmpty()) {
			pat.setLname(patBean.getLname());
		}
		
		
		return pat;
	}
	
	private PatientBean mapDomainToBean(Patient patBean) {
		PatientBean pat = new PatientBean();
		if(patBean.getPatId() >0) {
			pat.setId(patBean.getPatId());
		}
		if(patBean.getFname() != null && !patBean.getFname().isEmpty()) {
			pat.setFname(patBean.getFname());
		}
		if(patBean.getLname() != null && !patBean.getLname().isEmpty()) {
			pat.setLname(patBean.getLname());
		}
		
		
		return pat;
	}

}
