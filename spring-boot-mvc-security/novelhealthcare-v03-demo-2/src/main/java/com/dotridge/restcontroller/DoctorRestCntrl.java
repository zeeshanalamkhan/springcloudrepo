package com.dotridge.restcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dotridge.bean.DoctorBean;
import com.dotridge.service.DoctorService;

@RestController
@RequestMapping("/doctorServiceApi")
public class DoctorRestCntrl {

	@Autowired
	HttpServletRequest req;
	
	@Autowired
	DoctorService docService;
	
	@GetMapping(value="/getAllDoctors",produces="application/json")
	public List<DoctorBean> getAllDoctors(){
		String token = req.getHeader("loginToken");
		List<DoctorBean> docList = null;
		if(token != null){
			docList = docService.getAllDoctors();
		}
		
		return docList;
	}
}
