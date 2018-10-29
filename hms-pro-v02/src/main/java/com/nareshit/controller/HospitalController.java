package com.nareshit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.bean.HospitalBean;
import com.nareshit.domain.Hospital;
import com.nareshit.repository.IHospitalRepository;
import com.nareshit.utility.HospitalMapper;

@RestController
@RequestMapping("/hospApi")
public class HospitalController {

	@Autowired
	private IHospitalRepository hospRepo;
	
	@PostMapping(value="/addHospital")
	public HospitalBean addHospotal(@RequestBody HospitalBean hospBean) {
		
		Hospital hosp = HospitalMapper.mapBeanToDomain(hospBean);
		hosp = hospRepo.save(hosp);
		hospBean = HospitalMapper.mapDomainToBean(hosp);
		return hospBean;
		
	}
}
