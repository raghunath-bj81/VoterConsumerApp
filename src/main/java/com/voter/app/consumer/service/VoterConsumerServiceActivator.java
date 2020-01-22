package com.voter.app.consumer.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.voter.app.consumer.dao.ConsumerDAO;
import com.voter.app.consumer.mappers.VoterMapper;
import com.voter.app.consumer.model.EligibleVoters;
import com.voter.app.consumer.model.InEligibleVoters;
import com.voter.app.consumer.model.VoterInformation;

/**
 * Consumer integration service which consumes and filters the voter 
 * information based on their ages from the integration flow.
 * 
 * @author rjosula
 *
 */
@Component
public class VoterConsumerServiceActivator {
	
	@Autowired
	private ConsumerDAO consumerDAO;
	
	public Message<VoterInformation> consumerMessage(VoterInformation voterMsg) {
		System.out.println("Input Message from EligibleVoters Name : "+ voterMsg.getVoterName() + " is this record eligible for voting? -> " + voterMsg.isEligible());
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("iseligibleVoter", String.valueOf(voterMsg.isEligible()));
		MessageHeaders msgHeader = new MessageHeaders(headers);
		Message<VoterInformation> voterMessage = MessageBuilder.createMessage(voterMsg, msgHeader);
		return voterMessage;
	}
	
	/**
	 * On successfull integration filter condition of voter age >= 18 this method shall be triggered.
	 * Also saves the data into database after which voter member will get email notification as well. 
	 * @param eligibleVoterMsg
	 */
	public void success(Message<VoterInformation> eligibleVoterMsg) {
		VoterMapper mapper = new VoterMapper();
		EligibleVoters eligibleVoters = mapper.mapEligibleVoters(eligibleVoterMsg.getPayload());
		System.out.println("EligibleVoters has age >= 18 ");
		eligibleVoters.setStatus("Voter Registration accepted");
		try {
			consumerDAO.saveEligibleVoters(eligibleVoters);
		} catch(Exception ex) {
			System.out.println("Error occurred while saving eligible Voter");
		}
	}
	
	/**
	 * On failure of a condition from the integration filter where voter age < 18 this method shall be triggered.
	 * Also saves the data into database after which voter member will get email notification as well. 
	 * @param eligibleVoterMsg
	 */
	public void discard(Message<VoterInformation> ineligibleVoterMsg) {
		VoterMapper mapper = new VoterMapper();
		InEligibleVoters ineligibleVoters = mapper.mapInEligibleVoters(ineligibleVoterMsg.getPayload());
		System.out.println("InEligibleVoters has age < 18 ");
		ineligibleVoters.setStatus("Voter Registration rejected..");
		try {
			consumerDAO.saveIneligibleVoters(ineligibleVoters);
		} catch(Exception ex) {
			System.out.println("Error occurred while saving in-eligible Voter");
		}
	}
}