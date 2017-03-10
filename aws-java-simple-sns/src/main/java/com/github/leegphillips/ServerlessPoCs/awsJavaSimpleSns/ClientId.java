package com.github.leegphillips.ServerlessPoCs.awsJavaSimpleSns;

import java.io.*;
import java.nio.charset.Charset;

public class ClientId {
    @Override
    public String toString() {
        ClassLoader classLoader = getClass().getClassLoader();
        File secrets = new File(classLoader.getResource("aws.secrets").getFile());
        try (InputStream fis = new FileInputStream(secrets);
                InputStreamReader isr = new InputStreamReader(fis, Charset.defaultCharset());
                BufferedReader br = new BufferedReader(isr)) {
            return br.readLine().trim();
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }
}
