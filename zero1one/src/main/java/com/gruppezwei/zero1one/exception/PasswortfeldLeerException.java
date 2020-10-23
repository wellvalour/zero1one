package com.gruppezwei.zero1one.exception;

public class PasswortfeldLeerException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	public PasswortfeldLeerException() {
		super();
	}

	public PasswortfeldLeerException(String errorMessage) {
		super(errorMessage);
	}
}
