package de.jeha.opennebula.client;

import de.jeha.opennebula.client.vm.VirtualMachinePool;

public class SimpleClient {

    private Client client;

    public SimpleClient(String basicAuth, String endPointUrl) throws ClientConfigurationException {
        this.client = new Client(basicAuth, endPointUrl);
    }

    public Response getVersion() {
        return client.call(Client.Action.VERSION);
    }

    public VirtualMachinePool getVirtualMachinePool() {
        throw new UnsupportedOperationException("not yet implemented");
    }
}
