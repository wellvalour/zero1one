package com.gruppezwei.zero1one.exception;

public class PasswordsDoNotMatchException extends IllegalArgumentException{
	private static final long serialVersionUID = 1L;

	public PasswordsDoNotMatchException() {
        super();
    }
	
	public PasswordsDoNotMatchException(String errorMessage) {
        super(errorMessage);
    }
}
