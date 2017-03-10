package com.github.leegphillips.ServerlessPoCs.awsJavaSimpleSns;

import java.util.Map;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.serverless.ApiGatewayResponse;
import com.serverless.Response;
import org.apache.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Publisher implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	private static final Logger LOG = Logger.getLogger(Publisher.class);

	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		LOG.info("Received: " + input);

		String timestamp = Long.toString(System.currentTimeMillis());

		AmazonSNS sns = AmazonSNSClientBuilder.defaultClient();
		sns.publish("arn:aws:sns:us-east-1:" + new ClientId() + ":message", timestamp);
		sns.publish("arn:aws:sns:us-east-1:" + new ClientId() + ":message", timestamp);

		return ApiGatewayResponse.builder()
				.setStatusCode(204)
				.build();
	}
}
