package de.jeha.opennebula.client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;

class Client {

    public enum Action {
        VERSION("system.version");

        private final String name;

        Action(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }
    }

    private final String basicAuth;
    private final String endPointUrl;
    private XmlRpcClient client;

    public Client(String basicAuth, String endPointUrl) throws ClientConfigurationException {
        this.basicAuth = basicAuth;
        this.endPointUrl = endPointUrl;
        initialize();
    }

    public Response call(Action action, Object... args) {

        boolean success = false;
        String message = null;

        try {
            Object[] params = new Object[args.length + 1];
            params[0] = basicAuth;
            System.arraycopy(args, 0, params, 1, args.length);

            Object[] result = (Object[]) client.execute("one." + action.getName(), params);

            success = (Boolean) result[0];

            if (result.length > 1) {
                try {
                    message = (String) result[1];
                } catch (ClassCastException e) {
                    message = result[1].toString();
                }
            }
        } catch (XmlRpcException e) {
            message = e.getMessage();
        }

        return new Response(success, message);
    }

    //------------------------------------------------------------------------------------------------------------------

    private void initialize() throws ClientConfigurationException {
        XmlRpcClientConfigImpl clientConfig = new XmlRpcClientConfigImpl();

        try {
            clientConfig.setServerURL(new URL(this.endPointUrl));
        } catch (MalformedURLException e) {
            throw new ClientConfigurationException("The URL " + this.endPointUrl + " is malformed.", e);
        }

        this.client = new XmlRpcClient();
        this.client.setConfig(clientConfig);
    }
}
