package com.nareshit.utility;

import java.util.ArrayList;
import java.util.List;

import com.nareshit.bean.DoctorBean;
import com.nareshit.bean.PatientBean;
import com.nareshit.domain.Doctor;
import com.nareshit.domain.Patient;

public class DoctorMapper {

	public static Doctor mapBeanToDomain(DoctorBean drb){
		Doctor dr=new Doctor();
		dr.setFname(drb.getFname());
		dr.setLname(drb.getLname());
		dr.setMobile(drb.getMobile());
		dr.setEmail(drb.getEmail());
		dr.setPassword(drb.getPassword());
		dr.setConpassword(drb.getCpassword());
		dr.setStatus(Boolean.parseBoolean(String.valueOf(Status.getCodeByName(drb.getStatus()))));
		
		List<Patient> lp=null;
		List<PatientBean> lpb=drb.getPinfo();
		if(lpb !=null && lpb.size()>0) {
			lp=new ArrayList<Patient>();
			for(PatientBean pb:lpb) {
				lp.add(PatientMapper.mapBeanToDomain(pb));
			}
			dr.setPatients(lp);
		}
		
		return dr;
	}

	public static DoctorBean mapDomainToBean(Doctor dr) {
		
		DoctorBean drb=new DoctorBean();
		
		drb.setFname(dr.getFname());
		drb.setLname(dr.getLname());
		drb.setMobile(drb.getMobile());
		drb.setEmail(drb.getEmail());
		drb.setPassword(drb.getPassword());
		drb.setCpassword(drb.getCpassword());
		 boolean drs=dr.isStatus();
		 
		 List<PatientBean> ldb=null;
		 
		 List<Patient> lp=dr.getPatients();
		 
		 if(lp !=null && lp.size()>0) {
			 ldb=new ArrayList <PatientBean>();
			 for(Patient p:lp) {
				 
				 ldb.add(PatientMapper.mapDomainToBean(p));
			 }
			 drb.setPinfo(ldb);		
			 }
		
		return drb;
	}
}
