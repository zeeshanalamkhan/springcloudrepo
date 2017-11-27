package com.nareshit.proxy;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient(name="doctor-service-proxy",url="localhost:7070")
@FeignClient(name="doctor-service")
public interface DoctorServiceProxy {

	@RequestMapping(path="/doctorCntrl/getDoctDetailsByName/{docName}")
	public ResponseEntity<String> getDoctorByName(@PathVariable("docName")String name);
}
