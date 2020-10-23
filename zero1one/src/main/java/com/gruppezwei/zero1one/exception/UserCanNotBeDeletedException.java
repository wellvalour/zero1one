package com.gruppezwei.zero1one.exception;

public class UserCanNotBeDeletedException extends IllegalArgumentException{
	private static final long serialVersionUID = 1L;

	public UserCanNotBeDeletedException() {
		super();
	}

	public UserCanNotBeDeletedException(String errorMessage) {
		super(errorMessage);
	}
}
