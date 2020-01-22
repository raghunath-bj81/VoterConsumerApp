package com.voter.app.consumer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.voter.app.consumer.communicate.VoterMailSender;
import com.voter.app.consumer.model.EligibleVoters;
import com.voter.app.consumer.model.InEligibleVoters;
import com.voter.app.consumer.model.VoterEmailTemplate;

/**
 * 
 * @author rjosula
 *
 */
@Repository
public class ConsumerDAOImpl implements ConsumerDAO {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private VoterMailSender mailSender;

	@Override
	public void saveEligibleVoters(EligibleVoters eligibleVoter) {
		try {
			System.out.println("Saving Eligible Voter Data..");
			Query query = new Query();
			query.addCriteria(Criteria.where("voterId").is(eligibleVoter.getvoterId()));

			EligibleVoters votersChk = mongoTemplate.findOne(query, EligibleVoters.class);
			if(votersChk == null) {
				mongoTemplate.save(eligibleVoter);
			} else {
				Update update = new Update();
				update.set("voterAddress", eligibleVoter.getvoterAddress());
				update.set("state", eligibleVoter.getState());
				mongoTemplate.updateFirst(query, update, EligibleVoters.class);
			}
			VoterEmailTemplate emailTemplate = new VoterEmailTemplate();
			emailTemplate.setToAddress(eligibleVoter.getEmailId());
			emailTemplate.setSubject("Voter Application Status : ");
			emailTemplate.setMailContent("Dear " + eligibleVoter.getvoterName() + ",\n \nYour Voter Application has been recieved and will be processed soon.\n "
					+ "\nPlease be updated with the notifications.\n \nRegards,\nChief Electrol Officer Admin,\nTelangana State,\nContact Us@ https://ceotelangana.nic.in/");
			emailTemplate.setReferenceId(eligibleVoter.getReferenceId());
			mailSender.sendEmail(emailTemplate);
		} catch(Exception ex) {
			System.out.println("Error occured while saving the eligible voter information...");
		}
	}

	@Override
	public void saveIneligibleVoters(InEligibleVoters ineligibleVoter) {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("voterId").is(ineligibleVoter.getvoterId()));

			EligibleVoters votersChk = mongoTemplate.findOne(query, EligibleVoters.class);
			if(votersChk == null) {
				mongoTemplate.save(ineligibleVoter);
			} else {
				Update update = new Update();
				update.set("voterAddress", ineligibleVoter.getvoterAddress());
				update.set("state", ineligibleVoter.getState());
				mongoTemplate.updateFirst(query, update, EligibleVoters.class);
			}
			VoterEmailTemplate emailTemplate = new VoterEmailTemplate();
			emailTemplate.setToAddress(ineligibleVoter.getEmailId());
			emailTemplate.setSubject("Voter Application Status : ");
			emailTemplate.setMailContent("Dear Applicant,\n \nYour Voter Application has been recieved and will be processed soon.\n \nPlease be updated with the notifications.\n \nRegards,\nVoter Admin,\nTelangana State");
			emailTemplate.setReferenceId(ineligibleVoter.getReferenceId());
			mailSender.sendEmail(emailTemplate);
		} catch(Exception ex) {
			System.out.println("Error occured while saving the ineligibleVoter voter information...");
		}
	}
}
