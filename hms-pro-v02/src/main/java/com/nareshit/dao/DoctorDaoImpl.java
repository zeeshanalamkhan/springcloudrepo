package com.nareshit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nareshit.domain.Doctor;
import com.nareshit.domain.User;

@Repository
public class DoctorDaoImpl implements DoctorDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Doctor addDoctor(Doctor doct) {
		Session ses = sf.openSession();
		ses.save(doct);
		ses.beginTransaction().commit();
		return doct;
	}

	@Override
	public Doctor getDoctorByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> searchDoctor(String name, String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
