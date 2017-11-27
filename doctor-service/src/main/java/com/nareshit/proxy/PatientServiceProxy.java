package com.nareshit.proxy;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@RibbonClient
//@FeignClient(name="patient-service-proxy",url="localhost:9090")
//@FeignClient(name="patient-service-proxy")
@FeignClient(name="pateint-service")
public interface PatientServiceProxy {

	@RequestMapping(path="/patientCntrl/createPatient",method=RequestMethod.POST)
	public ResponseEntity<String> addPatient(@RequestBody String patientJson);
	
}
