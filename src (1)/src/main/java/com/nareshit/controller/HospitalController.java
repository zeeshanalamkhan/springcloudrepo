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
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired 
	private IHospitalRepository hrepo;
	
	@PostMapping(value="/save")
	public HospitalBean saveHospital(@RequestBody HospitalBean hb) {
		
		Hospital h=HospitalMapper.mapBeanToDomain(hb);
		h=hrepo.save(h);
		hb=HospitalMapper.mapDomainToBean(h);
		return hb;
	}
	
	
}
