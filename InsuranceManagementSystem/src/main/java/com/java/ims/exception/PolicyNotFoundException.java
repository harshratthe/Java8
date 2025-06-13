package com.java.ims.exception;

public class PolicyNotFoundException extends Exception {

	public PolicyNotFoundException() {
        super("Policy not found with the given ID.");
    }

    public PolicyNotFoundException(String message) {
        super(message);
    }
}
