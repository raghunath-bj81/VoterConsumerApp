package com.voter.app.consumer.dao;

import com.voter.app.consumer.model.EligibleVoters;
import com.voter.app.consumer.model.InEligibleVoters;

/**
 * Interface to define the operations on voter objects
 * @author rjosula
 *
 */
public interface ConsumerDAO {

	public void saveEligibleVoters(EligibleVoters eligibleVoter);
	public void saveIneligibleVoters(InEligibleVoters ineligibleVoter);
}
