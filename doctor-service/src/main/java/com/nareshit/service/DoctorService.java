package com.nareshit.service;

import java.util.List;

import com.nareshit.bean.DoctorBean;



public interface DoctorService {

	public DoctorBean createDoctor(DoctorBean patBean);
	public DoctorBean  updateDoctor(DoctorBean patBean);
	public DoctorBean   getDoctorByid(int patId);
	public List<DoctorBean> getAllDoctors();
	public List<DoctorBean> getAllDoctors(int currPage,int noOfRecPerPage);
	public boolean deleteDoctor(int patId);
	public List<DoctorBean> SearcgAllDoctorsByName(String name);
}
