package de.jeha.opennebula.client;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleClientTest {

    @Test(expected = ClientConfigurationException.class)
    public void configWithNull() throws ClientConfigurationException {
        new SimpleClient(null, null);
    }

    @Test
    @Ignore("todo: mock rpc request/response to make it work")
    public void version() throws ClientConfigurationException {
        SimpleClient client = new SimpleClient(null, "http://localhost:2633/RPC2");
        Response response = client.getVersion();

        assertEquals("4.10.0", response.getMessage());
    }

}
