package de.angelcode.jirabutler.webserver;

public class PortRangeException extends Exception {

	public PortRangeException() {
		this("ERROR: The port is not within the range.");
	}

	public PortRangeException(String errorMessage) {
		super(errorMessage);
	}
}
