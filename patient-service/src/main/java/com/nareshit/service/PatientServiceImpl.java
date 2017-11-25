package com.nareshit.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nareshit.bean.PatientBean;
import com.nareshit.dao.PatientDao;
import com.nareshit.dao.PatientJPARepo;
import com.nareshit.domain.Patient;
import com.nareshit.util.ServiceUtility;


@Service
public class PatientServiceImpl implements PatientService {

	private static final Logger logger = Logger.getLogger(PatientServiceImpl.class);
	@Autowired
	//CrudRepository<Patient, Integer> repo;
	//PatientJPARepo patDao;
	PatientDao patDao;
	
	@Autowired
	PatientJPARepo patJpaRepo;
	
	
	@Autowired
	ServiceUtility utils;
	
	@Override
	
	@Transactional(rollbackFor=Exception.class)
	public PatientBean createPatient(PatientBean patBean) {
		logger.info("am in create Patient");
		Patient pat = mapBeanToDomain(patBean);
		pat = patDao.savePatient(pat);
		return mapDomainToBean(pat);
	}

	@Override
	public PatientBean updatePatient(PatientBean patBean) {
		Patient pat = mapBeanToDomain(patBean);
		pat = patDao.updatePatient(pat);
		return mapDomainToBean(pat);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public PatientBean getPatientByid(int patId) {
		Patient pat = patDao.getPatientById(patId);
		return mapDomainToBean(pat);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public List<PatientBean> getAllPatients() {
		Iterable<Patient> iterable = patDao.getAllPatient();
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
		Pageable page = new PageRequest(currPage, noOfRecPerPage);
		
		List<Patient> patList = 	patDao.getAllPatientsByPaging(currPage, noOfRecPerPage);
		List<PatientBean> patBeanList = new ArrayList<PatientBean>();
		for(Patient pat:patList) {
			patBeanList.add(mapDomainToBean(pat));
		}
			return patBeanList;
	}

	@Override
	public boolean deletePatient(int patId) {
		patDao.deletePatinet(patId);
		Patient pat = patDao.getPatientById(patId);
		if(pat == null)
			 return true;
		
		return false;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public List<PatientBean> SearcgAllPatientsByName(String name) {
		//System.out.println("name in service is:\t"+name);
		logger.info("name in service is:\t"+name);
	List<Patient> patList = 	patJpaRepo.seachAllPatientsByName(name);
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
