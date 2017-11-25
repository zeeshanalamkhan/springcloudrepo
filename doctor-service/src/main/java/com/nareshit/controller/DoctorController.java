package com.nareshit.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.websocket.server.PathParam;

//import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.bean.DoctorBean;
import com.nareshit.service.DoctorService;
import com.nareshit.util.PropertiesUtil;
import com.nareshit.util.ServiceConstants;

@RestController
@RequestMapping("/doctorCntrl")
public class DoctorController {
	private static final Logger logger = Logger.getLogger(DoctorController.class.getName());
	@Autowired
	PropertiesUtil propsUtil;

	@Autowired
	private DoctorService patService;

		
	//@RequestMapping("/getDoctDetails")
	@GetMapping(value="/getDoctDetails")
	public ResponseEntity<DoctorBean> getDoctorDetailsById(@PathParam("patId") int patId) {

		DoctorBean pat = patService.getDoctorByid(patId);
		return new ResponseEntity<DoctorBean>(pat, HttpStatus.OK);
	}

	/**
	 * used to save the Doctor details where every registered Doctor is a locked
	 * user.
	 * 
	 * @param pat
	 * @return
	 */
	//@RequestMapping(value = "/createDoctor", method = RequestMethod.POST)
	@PostMapping(value="/createDoctor")
	public ResponseEntity<String> addDoctor(@RequestBody DoctorBean pat) {
		String dateFormat = propsUtil.getValueFromKey(ServiceConstants.NOVEL_HEALTH_DATE_FORMAT);
		System.out.println("date format is:\t" + dateFormat);
		pat.setCreatedDate(getNovelHealthDateFromat(dateFormat));

		pat = patService.createDoctor(pat);

		JSONObject json = new JSONObject();
		try {
			json.put("status", HttpStatus.CREATED.toString());
			json.put("patDetails", pat.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<String>(json.toString(), HttpStatus.CREATED);
	}

	//@RequestMapping(value = "/getAllDoctors")
	@GetMapping(value="/getAllDoctors")
	public ResponseEntity<String> getAllDoctors() {
		ResponseEntity<String> respEntity = null;
		try {
			List<DoctorBean> patBeanList = patService.getAllDoctors();
			JSONObject json = new JSONObject();
			json.put("patList", patBeanList);
			json.put("message", "get all Doctors");
			respEntity = new ResponseEntity<String>(json.toString(), HttpStatus.FOUND);
		} catch (Exception e) {
			JSONObject json = new JSONObject();
			try {
				json.put("error", e.getMessage());
				respEntity = new ResponseEntity<String>(json.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return respEntity;

	}

	//@RequestMapping(value = "/getAllDoctors/{currpage}/{noOfRecPage}")
	@GetMapping(value = "/getAllDoctors/{currpage}/{noOfRecPage}")
	public ResponseEntity<String> getAllDoctorsByPaging(@PathVariable("currpage") int currpage,
			@PathVariable("noOfRecPage") int noOfRecPage) {
		ResponseEntity<String> respEntity = null;
		try {
			System.out.println("curr page is:\t" + currpage);
			System.out.println("no.OfRecPerPage is:\t" + noOfRecPage);
			List<DoctorBean> patBeanList = patService.getAllDoctors(currpage, noOfRecPage);
			JSONObject json = new JSONObject();
			json.put("patList", patBeanList);
			json.put("message", "get all Doctors");
			respEntity = new ResponseEntity<String>(json.toString(), HttpStatus.FOUND);
		} catch (Exception e) {
			JSONObject json = new JSONObject();
			try {
				json.put("error", e.getMessage());
				respEntity = new ResponseEntity<String>(json.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return respEntity;

	}

	//@RequestMapping(value = "/searchAllDoctorsByName/{patName}")
	@GetMapping(value = "/searchAllDoctorsByName/{patName}")
	public ResponseEntity<String> searchDoctors(@PathVariable("patName") String patName) {
		logger.warning("pat name  in controller is:\t" + patName);
		ResponseEntity<String> respEntity = null;
		try {
			List<DoctorBean> patBeanList = patService.SearcgAllDoctorsByName(patName);
			JSONObject json = new JSONObject();
			json.put("patList", patBeanList);
			json.put("message", "get all Doctors");
			respEntity = new ResponseEntity<String>(json.toString(), HttpStatus.OK);
		} catch (Exception e) {
			JSONObject json = new JSONObject();
			try {
				json.put("error", e.getMessage());
				respEntity = new ResponseEntity<String>(json.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return respEntity;

	}

	private String getNovelHealthDateFromat(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}
	
	
}
