package com.nareshit.proxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import feign.Headers;



//@RibbonClient
//@FeignClient(name="patient-proxy")
@FeignClient(name="zuul-api-gateway")
//@FeignClient(name="patient-proxy",url="localhost:9096/patientApi")
public interface PatientApiProxy {

	@PostMapping(path = "/api/patient-service-proxy/patientApi/createPatient", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Headers("Authorization: {access_token}")
	public ResponseEntity<String> addPatient(@RequestHeader("Authorization") String access_token,
			@RequestBody String patient);
}
