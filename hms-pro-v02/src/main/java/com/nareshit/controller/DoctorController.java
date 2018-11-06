package com.nareshit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nareshit.service.DoctorService;

//@RestController
@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	public String getDocorBoard() {
		return "doctBoard";
				
	}
	
	
}
