package com.voter.app.consumer.communicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.voter.app.consumer.model.VoterEmailTemplate;

/**
 * Mail send component which will use the mail template and send an emails.
 * @author Raghunath
 *
 */
@Component
public class VoterMailSender {

	@Autowired
    private JavaMailSender javaMailSender;
	
	/**
	 * 
	 * @param subject
	 * @param mailContent
	 * @param reciepentTo
	 * @param reciepentCC
	 * @param reciepentBCC
	 * @param voterRefNo
	 */
	public void sendEmail(VoterEmailTemplate emailTemplate) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("thoya.mca@gmail.com");
        boolean isBccAvailable = (!(emailTemplate.getBccAddress().isEmpty())) ? false : true;
        if(isBccAvailable) {
        	msg.setBcc(emailTemplate.getBccAddress());
        }
        boolean isccAvailable = (!(emailTemplate.getCcAddress().isEmpty())) ? false : true;
        if(isccAvailable) {
        	msg.setCc(emailTemplate.getCcAddress());
        }
        msg.setSubject(emailTemplate.getSubject());
        msg.setText("Dear Applicant, \nYour Voter Application has been rejected due to the verification fail. \nPlease try applying in the next 30 days. \nWe regret the inconvenience caused. \nRegards,\nVoterAdmin,Telangana State");
        try {
        javaMailSender.send(msg);
        }
        catch(Exception ex) {
        	ex.printStackTrace();
        }
    }
}
