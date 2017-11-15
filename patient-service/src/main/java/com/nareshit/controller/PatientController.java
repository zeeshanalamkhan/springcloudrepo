package com.nareshit.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.nareshit.bean.PatientBean;
import com.nareshit.util.PropertiesUtil;
import com.nareshit.util.ServiceConstants;

@Controller
@RequestMapping("/patientCntrl")
public class PatientController {

	@Autowired
	PropertiesUtil propsUtil;
	
	@RequestMapping("/getPatDetails")
	public @ResponseBody PatientBean getPatientDetails() {
		PatientBean pat = new PatientBean();
		pat.setFname("john");
		pat.setLname("Kane");
		pat.setId(100);
		
		String dateFormat = propsUtil.getValueFromKey(ServiceConstants.NOVEL_HEALTH_DATE_FORMAT);
		System.out.println("date format is:\t"+dateFormat);
		pat.setCreatedDate(getNovelHealthDateFromat(dateFormat));
		return pat;
	}
	
	@RequestMapping(value="/createPatient",method=RequestMethod.POST)
	public ResponseEntity<String> addPatient(@RequestBody PatientBean pat) {
		pat.setId(100);
		
		String dateFormat = propsUtil.getValueFromKey(ServiceConstants.NOVEL_HEALTH_DATE_FORMAT);
		System.out.println("date format is:\t"+dateFormat);
		pat.setCreatedDate(getNovelHealthDateFromat(dateFormat));
		
		JsonObject json = new JsonObject();
		json.addProperty("status", HttpStatus.CREATED.toString());
		json.addProperty("patDetails", pat.toString());
		
		
		
		
		
		return new ResponseEntity<String>(json.toString(),HttpStatus.CREATED); 
	}
	
	private String getNovelHealthDateFromat(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}
}
