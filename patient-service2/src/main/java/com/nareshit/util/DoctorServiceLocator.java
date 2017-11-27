package com.nareshit.util;

import org.springframework.web.client.RestTemplate;

public class DoctorServiceLocator {

	public static String getDoctorByName(String name) {
		RestTemplate rt = new RestTemplate();
		String docDetails = rt.getForObject(ServiceConstants.DOCTOR_SERVICE_BY_NAME+"/"+name, String.class);
		return docDetails;
	}
}
