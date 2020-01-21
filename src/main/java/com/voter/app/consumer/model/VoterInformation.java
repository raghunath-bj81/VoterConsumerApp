package com.voter.app.consumer.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="voterinformation")
@XmlAccessorType(XmlAccessType.FIELD)
public class VoterInformation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name="voterId")
	private int voterId;
	
	@XmlElement(name="voterName")
	private String voterName;
	
	@XmlElement(name="voterAddress")
	private String voterAddress;
	
	@XmlElement(name="voterProvince")
	private String voterProvince;

	@XmlElement(name="isEligible")
	private boolean isEligible;
	
	@XmlElement(name="voterage")
	private int voterAge;
	
	@XmlElement(name="referenceId")
	private String referenceId;
	
	@XmlElement(name="emailId")
	private String emailId;
	
	public int getVoterId() {
		return voterId;
	}

	public void setVoterId(int voterId) {
		this.voterId = voterId;
	}

	public String getVoterName() {
		return voterName;
	}

	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}

	public String getVoterAddress() {
		return voterAddress;
	}

	public void setVoterAddress(String voterAddress) {
		this.voterAddress = voterAddress;
	}

	public String getVoterProvince() {
		return voterProvince;
	}

	public void setVoterProvince(String voterProvince) {
		this.voterProvince = voterProvince;
	}

	public boolean isEligible() {
		return isEligible;
	}

	public void setEligible(boolean isEligible) {
		this.isEligible = isEligible;
	}

	public int getVoterAge() {
		return voterAge;
	}

	public void setVoterAge(int voterAge) {
		this.voterAge = voterAge;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
}
