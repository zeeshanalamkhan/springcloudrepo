package com.nareshit.proxy;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PatientServiceApiProxy {

	//private final RestTemplate rt = new RestTemplate();
	
	public static String createPatient(String patientLoad) {
		RestTemplate rt = new RestTemplate();
		String uri = "http://localhost:9096/patientApi/createPatient";
		
		HttpHeaders header = new HttpHeaders();
		header.set("content-type", "application/json");
		
		HttpEntity<String> req = new HttpEntity<String>(patientLoad, header);
		
		ResponseEntity<String> resp = rt.exchange(uri, HttpMethod.POST, req, String.class);
		String patientInfo = resp.getBody();
		System.out.println("patient is:\t"+patientInfo);
		
		return patientInfo;
	}
}
