package com.nareshit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.nareshit.domain.Doctor;
import com.nareshit.util.ServiceConstants;



public interface DoctorJPARepo  extends PagingAndSortingRepository<Doctor, Integer>{

	@Query(value=ServiceConstants.SEARCH_DOCTOR_BY_NAME)
	public List<Doctor>  seachAllDoctorsByName(@Param("name")String name);
}
