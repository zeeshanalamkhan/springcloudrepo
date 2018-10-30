package com.nareshit.utility;

import com.nareshit.bean.PatientBean;
import com.nareshit.domain.Patient;

public class PatientMapper {
	
	public static Patient mapBeanToDomain(PatientBean pb) {
			
		Patient p=new Patient();
		p.setFname(pb.getFname());
		p.setLname(pb.getLname());
		p.setEmail(pb.getEmail());
		p.setMobile(pb.getMobile());
		p.setPassword(pb.getPassword());
		p.setConpassword(pb.getCpassword());
		p.setStatus((Boolean.parseBoolean(String.valueOf(Status.getCodeByName(pb.getStatus())))));
		
		
		return p;
	}
	
	public static PatientBean mapDomainToBean(Patient p) {
		
		PatientBean pb=new PatientBean();
		
		pb.setFname(p.getFname());
		pb.setLname(p.getLname());
		pb.setEmail(p.getEmail());
		pb.setMobile(p.getMobile());
		pb.setPassword(p.getPassword());
		pb.setCpassword(p.getConpassword());
		
		boolean pst=p.isStatus();
		
		return pb;
	}

}
