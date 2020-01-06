package com.voter.app.consumer.service;

import org.springframework.stereotype.Component;

@Component
public class VoterConsumerServiceActivator {
	
	
	public void consumerMessage(String strMessage) {
		System.out.println(strMessage);
	}

}
