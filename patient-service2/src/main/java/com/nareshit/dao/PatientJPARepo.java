package com.nareshit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.nareshit.domain.Patient;
import com.nareshit.util.PropertiesUtil;
import com.nareshit.util.ServiceConstants;


public interface PatientJPARepo  extends PagingAndSortingRepository<Patient, Integer>{

	
	//@Query("from Patient pat where pat.fname like '%:name%'")
	@Query(value=ServiceConstants.SEARCH_PATIENT_BY_NAME)
	
	public List<Patient>  seachAllPatientsByName(@Param("name")String name);
}
