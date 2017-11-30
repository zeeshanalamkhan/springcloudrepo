package com.nareshit.msgbroker;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface DoctorSource {

	public static String DOCTOR_QUEUE = "doctorQ";
	
	@Output(DOCTOR_QUEUE)
	public MessageChannel doctorQ();
}
