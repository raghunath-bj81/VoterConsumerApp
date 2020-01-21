package com.voter.app.consumer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

import com.voter.app.consumer.model.EligibleVoters;
import com.voter.app.consumer.model.InEligibleVoters;

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
    private JavaMailSender javaMailSender;

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
			sendEmail();
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
		} catch(Exception ex) {
			System.out.println("Error occured while saving the ineligibleVoter voter information...");
		}
	}
	
	void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("thoya.mca@gmail.com");

        msg.setSubject("Voter Application Status : OXG89819O398");
        msg.setText("Dear Applicant, \nYour Voter Application has been rejected due to the verification fail. \nPlease try applying in the next 30 days. \nWe regret the inconvenience caused. \nRegards,\nVoterAdmin,Telangana State");
        try {
        javaMailSender.send(msg);
        }
        catch(Exception ex) {
        	ex.printStackTrace();
        }

    }

}
