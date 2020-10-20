package com.gruppezwei.zero1one.exception;

public class ObjektAllreadyExistsException extends IllegalArgumentException{
	private static final long serialVersionUID = 1L;

	public ObjektAllreadyExistsException() {
        super();
    }
	
	public ObjektAllreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}
