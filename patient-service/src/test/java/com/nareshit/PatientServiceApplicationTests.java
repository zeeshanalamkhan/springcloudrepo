package com.nareshit;

import java.util.Base64;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.nareshit.bean.PatientBean;



@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceApplicationTests {

	
	private static final String PAT_DETAILS_URI = "http://localhost:7070/patient-service/patientCntrl/getPatDetails";
	
	private static final String CREATE_PAT_URI = "http://localhost:7070/patient-service/patientCntrl/createPatient";
	/*@Test
	public void contextLoads() {
	}*/
	
	
	@Test
	public void testGetPatDetails() {
		RestTemplate rt = new RestTemplate();
		
		String plainCred = "root:root";
		String encodedCred = new String(Base64Utils.encode(plainCred.getBytes()));
		String authToken = "Basic "+encodedCred;
		System.out.println("auth token is:\t"+authToken);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", authToken);
		
		HttpEntity requestEntity = new HttpEntity(headers);
		
		
		ResponseEntity<PatientBean> respEntity = rt.exchange(PAT_DETAILS_URI, HttpMethod.GET, requestEntity, PatientBean.class);
		PatientBean pat = respEntity.getBody();
		System.out.println(pat.toString());
		
		Assert.assertNotNull(pat);
		
	}
	
	
	@Test
	public void testCreatePatient() {
RestTemplate rt = new RestTemplate();
		
		String plainCred = "root:root";
		String encodedCred = new String(Base64Utils.encode(plainCred.getBytes()));
		String authToken = "Basic "+encodedCred;
		System.out.println("auth token is:\t"+authToken);
		
		//HttpHeaders headers = new HttpHeaders();
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String,String>();
		headers.add("Authorization", authToken);
		
		PatientBean patBean = new PatientBean();
		patBean.setFname("Ramu");
		patBean.setLname("kalyan");
		
		HttpEntity requestEntity = new HttpEntity(patBean, headers);
		
		ResponseEntity<String> respData = rt.exchange(CREATE_PAT_URI, HttpMethod.POST, requestEntity, String.class);
		String body = respData.getBody();
		System.out.println("respnse is:\t"+body);
		Assert.assertNotNull(body);
	
	}
	
	/*public static void main(String[] args) {
		String plainCred = "root:root";
		String encodedCred = new String(Base64Utils.encode(plainCred.getBytes()));
		String authToken = "Basic "+encodedCred;
		
		System.out.println(new String(Base64.getDecoder().decode(encodedCred.getBytes())));
	}*/
	

}
