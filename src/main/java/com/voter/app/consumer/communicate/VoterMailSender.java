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
        msg.setTo(emailTemplate.getToAddress());
        boolean isBccAvailable = (null != emailTemplate.getBccAddress() && !(emailTemplate.getBccAddress().isEmpty())) ? true : false;
        if(isBccAvailable) {
        	msg.setBcc(emailTemplate.getBccAddress());
        }
        boolean isccAvailable = (null != emailTemplate.getCcAddress() && !(emailTemplate.getCcAddress().isEmpty())) ? true : false;
        if(isccAvailable) {
        	msg.setCc(emailTemplate.getCcAddress());
        }
        msg.setSubject(new StringBuffer(emailTemplate.getSubject()).append(emailTemplate.getReferenceId()).toString());
        msg.setText(emailTemplate.getMailContent());
        try {
        javaMailSender.send(msg);
        }
        catch(Exception ex) {
        	ex.printStackTrace();
        }
    }
}
