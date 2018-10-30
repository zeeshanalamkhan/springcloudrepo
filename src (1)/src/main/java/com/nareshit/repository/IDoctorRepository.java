package com.nareshit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nareshit.domain.Doctor;
import com.nareshit.domain.Patient;

public interface IDoctorRepository extends CrudRepository<Doctor, Integer> {

/*	public List<Patient> addPatient(Patient p);
*/	
}
