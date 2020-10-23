package com.gruppezwei.zero1one.exception;

public class FieldCanNotBeEmptyException1 extends IllegalArgumentException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FieldCanNotBeEmptyException1() {
        super();
    }
	
	public FieldCanNotBeEmptyException1(String errorMessage) {
        super(errorMessage);
    }
}
