package com.nareshit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.bean.DoctorBean;
import com.nareshit.domain.Doctor;
import com.nareshit.repository.IDoctorRepository;
import com.nareshit.utility.DoctorMapper;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private IDoctorRepository drepo;
	
	@PostMapping(value="/save")
	public DoctorBean saveDoc(@RequestBody DoctorBean drb) {
		
		Doctor dr=DoctorMapper.mapBeanToDomain(drb);
		dr=drepo.save(dr);
		drb=DoctorMapper.mapDomainToBean(dr);
		
		return drb;
	}
	
}
