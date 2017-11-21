package com.nareshit.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceUtility {

	@Autowired
	PropertiesUtil props;
	
	public Date getNovelHealthDateFromString(String strDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(
				props.getValueFromKey(ServiceConstants.NOVEL_HEALTH_DATE_FORMAT));
		Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	public String getNovelHealthDateInString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(
				props.getValueFromKey(ServiceConstants.NOVEL_HEALTH_DATE_FORMAT));
		String strDate = null;
				strDate = sdf.format(date);
		
		return strDate;
	}
}
