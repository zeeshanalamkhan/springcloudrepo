package com.nareshit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.bean.PatientBean;
import com.nareshit.dao.PatientDao;
import com.nareshit.domain.Patient;
import com.nareshit.utility.PatientMapper;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDao patDao;
	
	@Override
	public PatientBean savePatient(Patient pat) {
		Patient patDoamin = patDao.addPatient(pat);
		return PatientMapper.mapDomainToBean(patDoamin);
	}

	@Override
	public List<PatientBean> getAllPatients() {
		List<Patient> doctList = patDao.getAllPatients();
		List<PatientBean> doctBeanList = PatientMapper.mapDomainListToBean(doctList.iterator());
		return doctBeanList;
	}

	@Override
	public PatientBean getPatientById(int id) {
        Patient pat = patDao.getPatientByid(id);
		return PatientMapper.mapDomainToBean(pat);
	}

	@Override
	public PatientBean updatePatient(Patient pat) {
		 pat = patDao.updatePatient(pat);
		return PatientMapper.mapDomainToBean(pat);
	}

}
