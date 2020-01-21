package com.voter.app.consumer.mappers;

import com.voter.app.consumer.model.EligibleVoters;
import com.voter.app.consumer.model.InEligibleVoters;
import com.voter.app.consumer.model.VoterInformation;

public class VoterMapper {

	public EligibleVoters mapEligibleVoters(VoterInformation voterInfo) {
		EligibleVoters eligibleVoterInfo = new EligibleVoters();
		eligibleVoterInfo.setvoterAge(voterInfo.getVoterAge());
		eligibleVoterInfo.setvoterId(voterInfo.getVoterId());
		eligibleVoterInfo.setvoterName(voterInfo.getVoterName());
		eligibleVoterInfo.setvoterAddress(voterInfo.getVoterAddress());
		eligibleVoterInfo.setState(voterInfo.getVoterProvince());
		return eligibleVoterInfo;
	}
	
	
	public InEligibleVoters mapInEligibleVoters(VoterInformation voterInfo) {
		InEligibleVoters inEligibleVoterInfo = new InEligibleVoters();
		inEligibleVoterInfo.setvoterAge(voterInfo.getVoterAge());
		inEligibleVoterInfo.setvoterId(voterInfo.getVoterId());
		inEligibleVoterInfo.setvoterName(voterInfo.getVoterName());
		inEligibleVoterInfo.setvoterAddress(voterInfo.getVoterAddress());
		inEligibleVoterInfo.setState(voterInfo.getVoterProvince());
		inEligibleVoterInfo.setRemarks("Voter Age is less than 18.. as fixed by Indian Govt");
		return inEligibleVoterInfo;
	}
}
