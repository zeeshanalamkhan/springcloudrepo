package com.nareshit.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.nareshit.bean.PatientBean;
import com.nareshit.dao.PatientDao;
import com.nareshit.domain.Patient;
import com.nareshit.util.ServiceUtility;


@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	//CrudRepository<Patient, Integer> repo;
	PatientDao patDao;
	
	
	@Autowired
	ServiceUtility utils;
	
	@Override
	public PatientBean createPatient(PatientBean patBean) {
		Patient pat = mapBeanToDomain(patBean);
		pat = patDao.save(pat);
		return mapDomainToBean(pat);
	}

	@Override
	public PatientBean updatePatient(PatientBean patBean) {
		Patient pat = mapBeanToDomain(patBean);
		pat = patDao.save(pat);
		return mapDomainToBean(pat);
	}

	@Override
	public PatientBean getPatientByid(int patId) {
		Patient pat = patDao.findOne(patId);
		return mapDomainToBean(pat);
	}

	@Override
	public List<PatientBean> getAllPatients() {
		Iterable<Patient> iterable = patDao.findAll();
		Iterator<Patient> it= iterable.iterator();
		List<PatientBean> patBeanList = new ArrayList<PatientBean>();
		while(it.hasNext()) {
			Patient pat = it.next();
			patBeanList.add(mapDomainToBean(pat));
		}
		return patBeanList;
	}

	@Override
	public List<PatientBean> getAllPatients(int currPage, int noOfRecPerPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePatient(int patId) {
		patDao.delete(patId);
		boolean isNotDeleted = patDao.exists(patId);
		if(isNotDeleted)
			return false;
		return true;
	}

	@Override
	public List<PatientBean> SearcgAllPatientsByName(String name) {
		System.out.println("name in service is:\t"+name);
	List<Patient> patList = 	patDao.seachAllPatientsByName(name);
	List<PatientBean> patBeanList = new ArrayList<PatientBean>();
	for(Patient pat:patList) {
		patBeanList.add(mapDomainToBean(pat));
	}
		return patBeanList;
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
		
		if(patBean.getCreatedDate() != null && !patBean.getCreatedDate().isEmpty()) {
			pat.setCreateDate(utils.getNovelHealthDateFromString(patBean.getCreatedDate()));
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
		
		if(patBean.getCreateDate() != null) {
			pat.setCreatedDate(utils.getNovelHealthDateInString(patBean.getCreateDate()));
		}
		
		return pat;
	}

}
