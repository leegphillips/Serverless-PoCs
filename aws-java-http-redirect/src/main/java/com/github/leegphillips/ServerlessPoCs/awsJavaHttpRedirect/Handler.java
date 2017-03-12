package com.github.leegphillips.ServerlessPoCs.awsJavaHttpRedirect;

import java.util.HashMap;
import java.util.Map;

import com.serverless.ApiGatewayResponse;
import com.serverless.Response;
import org.apache.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Handler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	private static final Logger LOG = Logger.getLogger(Handler.class);

	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		LOG.info("received: " + input);
		Map<String, String> headers = new HashMap<>();
		headers.put("Location:", "https://www.github.com");
		return ApiGatewayResponse.builder()
//				.setStatusCode(302)
				.setHeaders(headers)
				.build();
	}
}
