package com.gruppezwei.zero1one.exception;

public class TypExistiertNichtOderLeerException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	public TypExistiertNichtOderLeerException() {
        super();
    }
	
	public TypExistiertNichtOderLeerException(String errorMessage) {
        super(errorMessage);
    }
}
