package com.nareshit.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.JsonObject;
import com.nareshit.bean.PatientBean;
import com.nareshit.service.PatientService;
import com.nareshit.util.PropertiesUtil;
import com.nareshit.util.ServiceConstants;

@Controller
@RequestMapping("/patientCntrl")
public class PatientController {

	@Autowired
	PropertiesUtil propsUtil;
	
	@Autowired
	private PatientService patService;
	
	@RequestMapping("/getPatDetails")
	public ResponseEntity<PatientBean> getPatientDetailsById(@PathParam("patId")int patId) {
		
		PatientBean pat = patService.getPatientByid(patId);
		return new ResponseEntity<PatientBean>(pat,HttpStatus.OK);
	}
	
	/**
	 * used to save the patient details 
	 * where every registered patient is a 
	 * locked user.
	 * @param pat
	 * @return
	 */
	@RequestMapping(value="/createPatient",method=RequestMethod.POST)
	public ResponseEntity<String> addPatient(@RequestBody PatientBean pat) {
		String dateFormat = propsUtil.getValueFromKey(ServiceConstants.NOVEL_HEALTH_DATE_FORMAT);
		System.out.println("date format is:\t"+dateFormat);
		pat.setCreatedDate(getNovelHealthDateFromat(dateFormat));
		
		pat = patService.createPatient(pat);
		
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
