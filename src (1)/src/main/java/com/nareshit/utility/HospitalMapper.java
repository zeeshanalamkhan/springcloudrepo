package com.nareshit.utility;

import java.util.ArrayList;
import java.util.List;

import com.nareshit.bean.AddressBean;
import com.nareshit.bean.HospitalBean;
import com.nareshit.domain.Address;
import com.nareshit.domain.Hospital;

public class HospitalMapper {

	
	public static Hospital mapBeanToDomain(HospitalBean hb) {
	
		Hospital h=new Hospital();
		h.setName(hb.getName());
		h.setEmail(hb.getEmail());
		h.setPhone(hb.getPhone());
		h.setFax(hb.getFax());
		h.setStatus(Boolean.parseBoolean(String.valueOf(Status.getCodeByName(hb.getStatus()))));
		
		List<Address> al=null;
		
		
		List<AddressBean> abl=hb.getAddrInfo();
		if(abl!=null && abl.size()>0) {
			al=new ArrayList<Address>();
		for(AddressBean ab:abl) {
			al.add(AddressMapper.mapBeanToDomain(ab));
		}
		h.setAddrList(al);
		
		}
		
		return h;
	}
	
	
	public static HospitalBean mapDomainToBean(Hospital hd) {
		
		HospitalBean hb=new HospitalBean();
		hb.setName(hd.getName());;
		hb.setEmail(hd.getEmail());
		hb.setPhone(hd.getPhone());
		hb.setFax(hd.getFax());
		  boolean hs=hd.isStatus();
		  hb.setStatus(String.valueOf(hs));

		  
		  List<AddressBean> abl=null;
		  
		  List<Address> al=hd.getAddrList();
		  
		  if(al !=null && al.size()>0) {
			  abl =new ArrayList<AddressBean>();

			  for(Address ad:al) {
				  
				  abl.add(AddressMapper.mapDomainToBean(ad));
			  }
	 		  hb.setAddrInfo(abl);
		  }
		
		return hb;
		
	}
	
	
	
}
