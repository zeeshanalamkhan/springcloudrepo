package com.nareshit.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nareshit.bean.HospitalBean;
import com.nareshit.domain.Hospital;
import com.nareshit.repository.IHospitalRepository;
import com.nareshit.utility.HospitalMapper;

//@RestController
@Controller
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private IHospitalRepository hospRepo;
	
	@RequestMapping
	public String getHomePage(Model model) {
		String msg = "welcome to hms pro";
		model.addAttribute("message", msg);
		model.addAttribute("hospBean", new HospitalBean());
		
		return "home";
	}
	
		
	@GetMapping(value="/getHospitalPage")
	public String addHospotal(Model model) {
		System.out.println("get hospital page");
		model.addAttribute("hospBean", new HospitalBean());
		return "addHospital";
				
		
	}
	
	@PostMapping(value="/addHospital")
	public String addHospotal(@ModelAttribute("hospBean") HospitalBean hospBean) {
		System.out.println("add hospital ");
		Hospital hosp = HospitalMapper.mapBeanToDomain(hospBean);
		hosp = hospRepo.save(hosp);
		hospBean = HospitalMapper.mapDomainToBean(hosp);
		//return "addHospital";
		return "redirect:./getAllHospitals";
		
	}
	
	@GetMapping(value="/getAllHospitals")
	public String  findHospotal(Model  model) {
		Iterator<Hospital> hospDomainsList = hospRepo.findAll().iterator();
		List<HospitalBean> hospBeanList = HospitalMapper.mapDomainListToBean(hospDomainsList);
		model.addAttribute("hospList", hospBeanList);
		
		return "hospList";
	}
	
	@GetMapping(value="/deleteHosp/{id}")
	public String  delteHospotal(Model  model,@PathVariable("id") int id) {
		hospRepo.delete(id);
		Iterator<Hospital> hospDomainsList = hospRepo.findAll().iterator();
		List<HospitalBean> hospBeanList = HospitalMapper.mapDomainListToBean(hospDomainsList);
		model.addAttribute("hospList", hospBeanList);
		return "hospList";
	}
	
	@GetMapping(value="/editHosp/{id}")
	public String  editHospotal(Model  model,@PathVariable("id") int id) {
		Hospital hosp = hospRepo.findOne(id);
		HospitalBean hospBean = HospitalMapper.mapDomainToBean(hosp);
		model.addAttribute("hospBean", hospBean);
		return "editHospital";
	}
	
	@PostMapping(value="/updateHospital")
	public String updateHospotal(@ModelAttribute("hospBean") HospitalBean hospBean) {
		System.out.println("add hospital ");
		System.out.println(hospBean.getHospId());
		System.out.println(hospBean.getEmail());
		Hospital hosp = HospitalMapper.mapBeanToDomain(hospBean);
		hosp = hospRepo.save(hosp);
		hospBean = HospitalMapper.mapDomainToBean(hosp);
		//return "addHospital";
		return "redirect:./getAllHospitals";
		
	}
}
