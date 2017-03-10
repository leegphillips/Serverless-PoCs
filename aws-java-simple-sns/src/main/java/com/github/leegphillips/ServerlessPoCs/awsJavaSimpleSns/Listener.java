package com.github.leegphillips.ServerlessPoCs.awsJavaSimpleSns;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import org.apache.log4j.Logger;

public class Listener implements RequestHandler<SNSEvent, Void> {
    private static final Logger LOG = Logger.getLogger(Listener.class);

    @Override
    public Void handleRequest(SNSEvent snsEvent, Context context) {
        long now = System.currentTimeMillis();
        snsEvent.getRecords().stream().forEach(snsRecord -> LOG.info("Time lapse: " + (now - Long.valueOf(snsRecord.getSNS().getMessage()))));
        return null;
    }
}
