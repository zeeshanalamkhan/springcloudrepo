package com.nareshit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nareshit.bean.DoctorBean;

@Controller
@RequestMapping("/doctCntrl")
public class DoctorController {

	@RequestMapping("/getDetails")
	public @ResponseBody DoctorBean getDocDetails() {
		DoctorBean docBean = new DoctorBean();
		docBean.setId(100);
		docBean.setFname("ananath");
		
		return docBean;
	}
}
