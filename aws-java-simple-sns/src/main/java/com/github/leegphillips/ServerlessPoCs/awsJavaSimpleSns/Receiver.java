package com.github.leegphillips.ServerlessPoCs.awsJavaSimpleSns;

import java.util.HashMap;
import java.util.Map;

import com.serverless.ApiGatewayResponse;
import com.serverless.Response;
import org.apache.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Receiver implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	private static final Logger LOG = Logger.getLogger(Receiver.class);

	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		LOG.info("Received: " + input);
		Response responseBody = new Response(Long.toString(System.currentTimeMillis()));

		return ApiGatewayResponse.builder()
				.setStatusCode(200)
				.setObjectBody(responseBody)
				.build();
	}
}
