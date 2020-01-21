package com.voter.app.consumer.config;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Active MQ configuration file to register the Input and Output Queues to this application.
 * @author rjosula
 *
 */
@Configuration
public class ActiveMQConfig {

	private final String VOTER_VEIFN_INPUT_QUEUE_NAME = "VoterJsonInputQueue";
	
	private final String VOTER_VEIFN_JSON_OUTPUT_QUEUE_NAME = "VoterJsonOutputQueue";

	private final String VOTER_VEIFN_OUTPUT_QUEUE_NAME = "VoterXMLOutputQueue";


	/**
	 * EligibleVoters Input Queue to read the messages
	 * @return
	 */
	@Bean
	public Queue voterInputQueue() {
		return new ActiveMQQueue(VOTER_VEIFN_INPUT_QUEUE_NAME);
	}
	
	/**
	 * EligibleVoters Input Queue to read the messages
	 * @return
	 */
	@Bean
	public Queue voterJsonOutputQueue() {
		return new ActiveMQQueue(VOTER_VEIFN_JSON_OUTPUT_QUEUE_NAME);
	}

	/**
	 * EligibleVoters Input Queue to write the messages
	 * @return
	 */
	@Bean
	public Queue voterOutputQueue() {
		return new ActiveMQQueue(VOTER_VEIFN_OUTPUT_QUEUE_NAME);
	}
	
	@Bean
	public static Jackson2JsonObjectMapper getMapper() {
        ObjectMapper mapper = new ObjectMapper();
        return new Jackson2JsonObjectMapper(mapper);
    }
}
