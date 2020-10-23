package com.gruppezwei.zero1one.exception;

public class FieldCanNotBeEmptyException2 extends IllegalArgumentException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FieldCanNotBeEmptyException2() {
        super();
    }
	
	public FieldCanNotBeEmptyException2(String errorMessage) {
        super(errorMessage);
    }
}
