package com.nareshit.msgbroker;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;




@EnableBinding(DoctorSource.class)
public class DoctorSourceSender {

	
	@Output(DoctorSource.DOCTOR_QUEUE)
	@Autowired
	MessageChannel channel;
	
	
	
	public boolean sendData(Object obj) {
		System.out.println("data is :\t"+obj);
		return channel.send(MessageBuilder.withPayload(obj).build());
	}
}
