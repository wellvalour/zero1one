package com.gruppezwei.zero1one.exception;

public class UserAllreadyExistsException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	public UserAllreadyExistsException() {
		super();
	}

	public UserAllreadyExistsException(String errorMessage) {
		super(errorMessage);
	}
}
