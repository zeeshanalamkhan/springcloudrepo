package com.nareshit.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nareshit.bean.DoctorBean;
import com.nareshit.bean.HospitalBean;
import com.nareshit.domain.Doctor;
import com.nareshit.domain.Hospital;
import com.nareshit.service.DoctorService;
import com.nareshit.utility.DoctorMapper;
import com.nareshit.utility.HospitalMapper;

//@RestController
@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping
	public String getDocorBoard() {
		return "doctBoard";
				
	}
	
	@GetMapping(value="/addDoctorDefn")
	public String addHospotal(Model model) {
		System.out.println("get doctor page");
		model.addAttribute("doctBean", new DoctorBean());
		return "addDoctorDefn";
	}
	

	@PostMapping(value="/addDoctor")
	public String addHospotal(@ModelAttribute("doctBean") DoctorBean doctBean, Model model) {
		System.out.println("add hospital ");
		System.out.println("hospal data is:\t"+doctBean.getStatus());
		Doctor doct = DoctorMapper.mapBeanToDomain(doctBean);
		//hosp = hospRepo.save(hosp);
		doctBean =  doctorService.saveDoctor(doct);
		if(doctBean != null && doctBean.getId() >0) {
			List<DoctorBean> docBeanList = doctorService.getAllDoctors();
			model.addAttribute("docBeanList", docBeanList);
		}
		return "doctBoard";
	}
	
	
	
	
}
