package com.voter.app.consumer.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "voterinformation")
public class Voter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int personId;
	private String personName;
	private int personAge;
	private String personAddress;
	private String state;
	public int getpersonId() {
		return personId;
	}
	public void setpersonId(int personId) {
		this.personId = personId;
	}
	public String getpersonName() {
		return personName;
	}
	public void setpersonName(String personName) {
		this.personName = personName;
	}
	public int getpersonAge() {
		return personAge;
	}
	public void setpersonAge(int personAge) {
		this.personAge = personAge;
	}
	public String getpersonAddress() {
		return personAddress;
	}
	public void setpersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Voter(int personId, String personName, int personAge, String personAddress,
			String state) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.personAge = personAge;
		this.personAddress = personAddress;
		this.state = state;
	}
	
	public Voter() {
	}
	
	@Override
	public String toString() {
		return "Voter [personId=" + personId + ", personName=" + personName + ", personAge="
				+ personAge + ", personAddress=" + personAddress + ", state=" + state + "]";
	}
}
