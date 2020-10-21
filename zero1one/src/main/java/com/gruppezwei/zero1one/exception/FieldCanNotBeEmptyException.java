package com.gruppezwei.zero1one.exception;

public class FieldCanNotBeEmptyException extends IllegalArgumentException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FieldCanNotBeEmptyException() {
        super();
    }
	
	public FieldCanNotBeEmptyException(String errorMessage) {
        super(errorMessage);
    }
}
