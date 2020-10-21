package com.gruppezwei.zero1one.exception;

import java.sql.Timestamp;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gruppezwei.zero1one.controller.CiType;

@ControllerAdvice
public class CiExceptionHandler {

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public String handleException(Model model, EmptyResultDataAccessException ex){
		
		String message = "Das Item mit dem gearbeitet werden soll existiert nicht!";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		model.addAttribute("message", message);
		model.addAttribute("timestamp", timestamp);
		
		return "errormanual";
	}
	
	@ExceptionHandler(ObjektAllreadyExistsException.class)
	public String handleException(Model model, ObjektAllreadyExistsException ex){

		String message = "Das Item das angelegt werden soll existiert bereits!";
		CiType neu = new CiType();
		
		model.addAttribute("TypObj", neu);
		model.addAttribute("message", message);
		
		return "ci-typ";
	}
	
	@ExceptionHandler(FieldCanNotBeEmptyException.class)
	public String handleException(Model model, FieldCanNotBeEmptyException ex){

		String message = "Das Feld Name darf niemals leer sein!";
		CiType neu = new CiType();
		
		model.addAttribute("TypObj", neu);
		model.addAttribute("message", message);
		
		return "ci-typ";
	}
	
	@ExceptionHandler(TypeMussGesetztSeinException.class)
	public String handleException(Model model, TypeMussGesetztSeinException ex){

		String message = "Das Feld CiTyp darf niemals leer sein!";
		CiType neu = new CiType();
		
		model.addAttribute("TypObj", neu);
		model.addAttribute("message", message);
		
		return "ci-typ";//Recordanlegen-Seite + Model richtig befüllen
	}
	
	@ExceptionHandler(UserAllreadyExistsException.class)
	public String handleException(Model model, UserAllreadyExistsException ex){

		String message = ex.getMessage();
		CiType neu = new CiType();
		
		model.addAttribute("TypObj", neu);
		model.addAttribute("message", message);
		
		return "ci-typ";//User-Seite + Model richtig befüllen
	}
	
	
}
