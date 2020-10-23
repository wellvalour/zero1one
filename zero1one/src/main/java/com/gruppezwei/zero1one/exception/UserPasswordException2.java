package com.gruppezwei.zero1one.exception;

public class UserPasswordException2 extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	public UserPasswordException2() {
        super();
    }
	
	public UserPasswordException2(String errorMessage) {
        super(errorMessage);
    }
}
