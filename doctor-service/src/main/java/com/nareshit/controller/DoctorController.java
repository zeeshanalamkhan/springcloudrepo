package com.nareshit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.bean.DoctorBean;
import com.nareshit.proxy.PatientApiProxy;
import com.nareshit.proxy.PatientServiceApiProxy;
import com.nareshit.service.DoctorService;
import com.nareshit.util.ServiceUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RefreshScope
@RestController
@RequestMapping("/doctorApi")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	//@Autowired
	//private PatientServiceApiProxy patProxy;
	
	@Autowired
	private PatientApiProxy patProxy;
	
	@Autowired
	private HttpServletRequest rq;
	
	@Value("${doctor.fee}")
	private String docFee;
	
	@PostMapping(path = "/createDoctor", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addDoctor(@RequestBody DoctorBean doctorBean) {
		doctorBean = doctorService.addDoctor(doctorBean);
		return new ResponseEntity<String>(doctorBean.toString(), HttpStatus.OK);

	}
	
	
	@GetMapping(path = "/getDoctorByEmail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DoctorBean> getDoctorByName(@PathVariable("email") String email) {
		DoctorBean doctorBean = doctorService.getDoctorByEmailId(email);
		return new ResponseEntity<DoctorBean>(doctorBean, HttpStatus.OK);

	}
	
	

	//@HystrixCommand(fallbackMethod="addPatient_fallback")
	@PostMapping(path = "/createPatient", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addPatient(@RequestBody String patientBean) {
		System.out.println("doctor fee is:\t"+docFee);
		String header = rq.getHeader("Authorization");
		System.out.println("header is:\t"+header);
		//String bodyData = PatientServiceApiProxy.createPatient(patientBean);
		ResponseEntity<String> bodyData = patProxy.addPatient("Authorization"+header,patientBean);
		
		//email.sendEmail("");
		return new ResponseEntity<String>(bodyData.getBody(), HttpStatus.OK);

	}
	
	public ResponseEntity<String> addPatient_fallback(@RequestBody String patientBean) {
	
		String message = "Patient Service is down at this moment!! "
				+ "Please try after some time";
		
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}
	
	
	
	
	
	
	
	

}
