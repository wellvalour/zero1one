package com.gruppezwei.zero1one.exception;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CiExceptionHandler {

	@ExceptionHandler(SQLException.class)
	public String handleException(NumberFormatException ex){
		ex.getMessage();
		return "dashboard";
	}
	
	@ExceptionHandler(ObjektAllreadyExistsException.class)
	public String handleException(ObjektAllreadyExistsException ex){
		String i = ex.getMessage();
		
		return "error";
	}
}
