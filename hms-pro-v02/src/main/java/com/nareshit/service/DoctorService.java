package com.nareshit.service;

import org.springframework.stereotype.Service;

import com.nareshit.bean.DoctorBean;
import com.nareshit.domain.Doctor;


public interface DoctorService {

	public DoctorBean saveDoctor(Doctor hosp);
	
}
