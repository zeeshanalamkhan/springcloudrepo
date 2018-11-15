package com.nareshit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nareshit.domain.Patient;

@Repository
public class PatientDaoImpl implements PatientDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Patient addPatient(Patient doct) {
		Session ses = sf.openSession();
		ses.save(doct);
		ses.beginTransaction().commit();
		ses.close();
		return doct;
	}

	@Override
	public Patient getPatientByid(int id) {
		Session ses = sf.openSession();
		Patient pat = ses.load(Patient.class, id);
		//ses.close();
		return pat;
	}

	@Override
	public List<Patient> getAllPatients() {
		Session ses = sf.openSession();
		String getAllPatients = "from Patient d";
		Query q = ses.createQuery(getAllPatients);
		return q.list();		
	}

	@Override
	public List<Patient> searchPatient(String name, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient updatePatient(Patient pat) {
		Session ses = sf.openSession();
		ses.update(pat);
		ses.beginTransaction().commit();
		ses.close();
		return pat;
	}

}
