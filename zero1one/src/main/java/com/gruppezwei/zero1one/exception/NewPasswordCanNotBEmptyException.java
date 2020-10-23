package com.gruppezwei.zero1one.exception;

public class NewPasswordCanNotBEmptyException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	public NewPasswordCanNotBEmptyException() {
		super();
	}

	public NewPasswordCanNotBEmptyException(String errorMessage) {
		super(errorMessage);
	}
}
