package com.voter.app.consumer.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.voter.app.consumer.model.VoterInformation;

@Component
public class VoterConsumerServiceActivator {
	
	
	public Message<VoterInformation> consumerMessage(VoterInformation voterMsg) {
		System.out.println("Input Message from Voter Name : "+ voterMsg.getVoterName() + " is this record eligible for voting? -> " + voterMsg.isEligible());
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("iseligibleVoter", String.valueOf(voterMsg.isEligible()));
		MessageHeaders msgHeader = new MessageHeaders(headers);
		Message<VoterInformation> voterMessage = MessageBuilder.createMessage(voterMsg, msgHeader);
		return voterMessage;
	}
	
 
	public void success(Message<VoterInformation> successMesg) {
		System.out.println("Voter has age >= 18 ");
	}
	
	public void discard(Message<VoterInformation> successMesg) {
		System.out.println("Voter has age < 18 ");
	}

}
