package com.gruppezwei.zero1one.exception;

public class PasswordsDoNotMatchException2 extends IllegalArgumentException{
	private static final long serialVersionUID = 1L;

	public PasswordsDoNotMatchException2() {
        super();
    }
	
	public PasswordsDoNotMatchException2(String errorMessage) {
        super(errorMessage);
    }
}
