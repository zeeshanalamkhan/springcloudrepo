package com.nareshit.dao;

import org.springframework.data.repository.CrudRepository;

import com.nareshit.domain.Patient;


public interface PatientDao  extends CrudRepository<Patient, Integer>{

}
