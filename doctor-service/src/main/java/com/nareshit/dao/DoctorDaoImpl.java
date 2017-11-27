package com.nareshit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nareshit.domain.Doctor;



@Repository
public class DoctorDaoImpl implements DoctorDao {

	@Autowired
	private SessionFactory sf;
	@Override
	public Doctor saveDoctor(Doctor pat) {
		//Session ses = sf.openSession();
		Session ses = sf.getCurrentSession();
		ses.save(pat);
		//ses.beginTransaction().commit();
		//ses.close();
		return pat;
	}

	@Override
	public Doctor updateDoctor(Doctor pat) {
		Session ses = sf.getCurrentSession();
		ses.update(pat);
		return pat;
	}

	@Override
	public boolean deleteDoctor(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Doctor getDoctorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> getAllDoctor() {
		Session ses = sf.getCurrentSession();
		Query q = ses.createQuery("from Doctor");
		
		return q.list();
	}

	@Override
	public List<Doctor> getAllDoctorsByPaging(int currPage, int noOfRecPerPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> searchAllDoctorsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor getDoctorByName(String name) {
		System.out.println("docname is:\t"+name);
        Session ses = sf.getCurrentSession();
        Query q = ses.createQuery("from Doctor d where d.fname=:docName");
        q.setParameter("docName", name);
		return (Doctor) q.uniqueResult();
	}

}
