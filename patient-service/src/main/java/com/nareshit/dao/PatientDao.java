package com.nareshit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nareshit.domain.Patient;


public interface PatientDao  extends CrudRepository<Patient, Integer>{

	@Query("from Patient pat where pat.fname like '%:name%'")
	public List<Patient>  seachAllPatientsByName(@Param("name")String name);
}
