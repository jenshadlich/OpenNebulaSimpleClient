package de.jeha.opennebula.client;

public class ClientConfigurationException extends Exception {

    private static final long serialVersionUID = -5504922230681513422L;

    public ClientConfigurationException(String message, Exception exception) {
        super(message, exception);
    }
}
