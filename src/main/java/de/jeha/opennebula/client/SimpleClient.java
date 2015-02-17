package de.jeha.opennebula.client;

import org.apache.xmlrpc.client.XmlRpcClient;

public class SimpleClient {
    private final String basicAuth;
    private final String endPointUrl;
    private XmlRpcClient client;

    public SimpleClient(String basicAuth, String endPointUrl) {
        this.basicAuth = basicAuth;
        this.endPointUrl = endPointUrl;
    }

    public Response call(){
        return null;
    }
}
