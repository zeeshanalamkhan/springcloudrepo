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

import com.nareshit.bean.DoctorBean;
import com.nareshit.dao.DoctorDao;
import com.nareshit.dao.DoctorJPARepo;
import com.nareshit.domain.Doctor;
import com.nareshit.util.ServiceUtility;


@Service
public class DoctorServiceImpl implements DoctorService {

	private static final Logger logger = Logger.getLogger(DoctorServiceImpl.class);
	@Autowired
	//CrudRepository<Doctor, Integer> repo;
	//DoctorJPARepo doctDao;
	DoctorDao doctDao;
	
	@Autowired
	DoctorJPARepo doctJpaRepo;
	
	
	@Autowired
	ServiceUtility utils;
	
	@Override
	
	@Transactional(rollbackFor=Exception.class)
	public DoctorBean createDoctor(DoctorBean docBean) {
		logger.info("am in create Doctor");
		Doctor pat = mapBeanToDomain(docBean);
		pat = doctDao.saveDoctor(pat);
		return mapDomainToBean(pat);
	}

	@Override
	public DoctorBean updateDoctor(DoctorBean docBean) {
		Doctor pat = mapBeanToDomain(docBean);
		pat = doctDao.updateDoctor(pat);
		return mapDomainToBean(pat);
	}

	@Override
	public DoctorBean getDoctorByid(int patId) {
		Doctor pat = doctDao.getDoctorById(patId);
		return mapDomainToBean(pat);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public List<DoctorBean> getAllDoctors() {
		List<Doctor> iterable = doctDao.getAllDoctor();
		Iterator<Doctor> it= iterable.iterator();
		List<DoctorBean> docBeanList = new ArrayList<DoctorBean>();
		while(it.hasNext()) {
			Doctor pat = it.next();
			docBeanList.add(mapDomainToBean(pat));
		}
		return docBeanList;
	}

	@Override
	public List<DoctorBean> getAllDoctors(int currPage, int noOfRecPerPage) {
		// TODO Auto-generated method stub
		Pageable page = new PageRequest(currPage, noOfRecPerPage);
		
		List<Doctor> patList = 	doctDao.getAllDoctorsByPaging(currPage, noOfRecPerPage);
		List<DoctorBean> docBeanList = new ArrayList<DoctorBean>();
		for(Doctor pat:patList) {
			docBeanList.add(mapDomainToBean(pat));
		}
			return docBeanList;
	}

	@Override
	public boolean deleteDoctor(int patId) {
		doctDao.deleteDoctor(patId);
		Doctor pat = doctDao.getDoctorById(patId);
		if(pat == null)
			 return true;
		
		return false;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public List<DoctorBean> SearcgAllDoctorsByName(String name) {
		//System.out.println("name in service is:\t"+name);
		logger.info("name in service is:\t"+name);
	List<Doctor> patList = 	doctJpaRepo.seachAllDoctorsByName(name);
	List<DoctorBean> docBeanList = new ArrayList<DoctorBean>();
	for(Doctor pat:patList) {
		docBeanList.add(mapDomainToBean(pat));
	}
	
		return docBeanList;
	}
	
	private Doctor mapBeanToDomain(DoctorBean docBean) {
		Doctor pat = new Doctor();
		
		if(docBean.getId() >0) {
			pat.setPatId(docBean.getId());
		}
		if(docBean.getFname() != null && !docBean.getFname().isEmpty()) {
			pat.setFname(docBean.getFname());
		}
		if(docBean.getLname() != null && !docBean.getLname().isEmpty()) {
			pat.setLname(docBean.getLname());
		}
		
		if(docBean.getCreatedDate() != null && !docBean.getCreatedDate().isEmpty()) {
			pat.setCreateDate(utils.getNovelHealthDateFromString(docBean.getCreatedDate()));
		}
		
		
		return pat;
	}
	
	private DoctorBean mapDomainToBean(Doctor docBean) {
		DoctorBean pat = new DoctorBean();
		if(docBean.getPatId() >0) {
			pat.setId(docBean.getPatId());
		}
		if(docBean.getFname() != null && !docBean.getFname().isEmpty()) {
			pat.setFname(docBean.getFname());
		}
		if(docBean.getLname() != null && !docBean.getLname().isEmpty()) {
			pat.setLname(docBean.getLname());
		}
		
		if(docBean.getCreateDate() != null) {
			pat.setCreatedDate(utils.getNovelHealthDateInString(docBean.getCreateDate()));
		}
		
		return pat;
	}

}
