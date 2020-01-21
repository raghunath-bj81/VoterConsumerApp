package com.voter.app.consumer.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ineligibleVoters")
public class InEligibleVoters implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int voterId;
	private String voterName;
	private int voterAge;
	private String voterAddress;
	private String state;
	private String remarks;
	private String status;
	private String emailId;
	private String referenceId;
	
	public int getvoterId() {
		return voterId;
	}
	public void setvoterId(int voterId) {
		this.voterId = voterId;
	}
	public String getvoterName() {
		return voterName;
	}
	public void setvoterName(String voterName) {
		this.voterName = voterName;
	}
	public int getvoterAge() {
		return voterAge;
	}
	public void setvoterAge(int voterAge) {
		this.voterAge = voterAge;
	}
	public String getvoterAddress() {
		return voterAddress;
	}
	public void setvoterAddress(String voterAddress) {
		this.voterAddress = voterAddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	public String isStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public InEligibleVoters() {
	}
	public InEligibleVoters(int voterId, String voterName, int voterAge, String voterAddress, String state,
			String remarks, String status, String emailId, String referenceId) {
		super();
		this.voterId = voterId;
		this.voterName = voterName;
		this.voterAge = voterAge;
		this.voterAddress = voterAddress;
		this.state = state;
		this.remarks = remarks;
		this.status = status;
		this.emailId = emailId;
		this.referenceId = referenceId;
	}
	@Override
	public String toString() {
		return "InEligibleVoters [voterId=" + voterId + ", voterName=" + voterName + ", voterAge=" + voterAge
				+ ", voterAddress=" + voterAddress + ", state=" + state + ", remarks=" + remarks + ", status=" + status
				+ ", emailId=" + emailId + ", referenceId=" + referenceId + "]";
	}
}