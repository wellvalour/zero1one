package com.gruppezwei.zero1one.exception;

public class TypeMussGesetztSeinException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	public TypeMussGesetztSeinException() {
        super();
    }

	public TypeMussGesetztSeinException(String errorMessage) {
        super(errorMessage);
    }
}
