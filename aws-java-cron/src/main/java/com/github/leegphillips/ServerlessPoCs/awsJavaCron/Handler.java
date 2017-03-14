package com.github.leegphillips.ServerlessPoCs.awsJavaCron;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Handler implements RequestHandler<Map<String, Object>, Void> {

	private static final Logger LOG = Logger.getLogger(Handler.class);

	@Override
	public Void handleRequest(Map<String, Object> input, Context context) {
		LOG.info("Invoked: " + input);
		return null;
	}
}
