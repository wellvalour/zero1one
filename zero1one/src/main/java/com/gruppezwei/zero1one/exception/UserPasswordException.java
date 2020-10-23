package com.gruppezwei.zero1one.exception;

public class UserPasswordException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	public UserPasswordException() {
        super();
    }
	
	public UserPasswordException(String errorMessage) {
        super(errorMessage);
    }
}
