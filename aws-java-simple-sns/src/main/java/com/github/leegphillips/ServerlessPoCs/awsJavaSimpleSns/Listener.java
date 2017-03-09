package com.github.leegphillips.ServerlessPoCs.awsJavaSimpleSns;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import org.apache.log4j.Logger;

public class Listener implements RequestHandler<SNSEvent, String> {
    private static final Logger LOG = Logger.getLogger(Listener.class);

    @Override
    public String handleRequest(SNSEvent snsEvent, Context context) {
        LOG.info("Listened: " + snsEvent.toString());
        return "1255";
    }
}
