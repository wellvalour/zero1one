package com.gruppezwei.zero1one.exception;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gruppezwei.zero1one.controller.Attributtypen;
import com.gruppezwei.zero1one.controller.CiSearch;
import com.gruppezwei.zero1one.controller.CiTypObjekt;
import com.gruppezwei.zero1one.controller.CiType;
import com.gruppezwei.zero1one.controller.HomeController;
import com.gruppezwei.zero1one.manager.ReadManager;


@ControllerAdvice
public class CiExceptionHandler {

	@Autowired
	ReadManager lesen;
	
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
		CiTypObjekt neu = new CiTypObjekt();
		List<CiType> SeaListRec = lesen.getCiTypeAll(); //Suchliste
		String Uname = HomeController.getUser();

		model.addAttribute("suchliste", SeaListRec);
		model.addAttribute("suche", new CiSearch());
		model.addAttribute("TypObj", neu);
		model.addAttribute("name", Uname);
		model.addAttribute("message", message);
		
		return "ci-typ";
	}
	
	@ExceptionHandler(FieldCanNotBeEmptyException.class)
	public String handleException(Model model, FieldCanNotBeEmptyException ex){

		String message = "Das Feld Ci-Typ Name darf niemals leer sein!";
		CiTypObjekt neu = new CiTypObjekt();
		List<CiType> SeaListRec = lesen.getCiTypeAll(); //Suchliste
		String Uname = HomeController.getUser();

		model.addAttribute("suchliste", SeaListRec);
		model.addAttribute("suche", new CiSearch());
		model.addAttribute("TypObj", neu);
		model.addAttribute("message", message);
		model.addAttribute("name", Uname);
		
		return "ci-typ";
	}
	
	@ExceptionHandler(TypeMussGesetztSeinException.class)
	public String handleException(Model model, TypeMussGesetztSeinException ex){

		String message = "Das Feld CiTyp darf niemals leer sein!";
		List<String> TypObj = lesen.getCiTypeAsString();
		String Uname = HomeController.getUser();

		model.addAttribute("search", TypObj);
		model.addAttribute("suche", new CiSearch());
		model.addAttribute("name", Uname);;
		model.addAttribute("message", message);
		
		return "ci-record";
	}
	
	@ExceptionHandler(UserAllreadyExistsException.class)
	public String handleException(Model model, UserAllreadyExistsException ex){

		String message = ex.getMessage();
		CiType neu = new CiType();
		
		model.addAttribute("TypObj", neu);
		model.addAttribute("message", message);
		
		return "profile1";// Beim user anlegen  wird im manager geworfen
	}
	
	@ExceptionHandler(UserPasswordException.class)
	public String handleException(Model model, UserPasswordException ex){

		String message = "Nachricht";
		CiType neu = new CiType();
		
		model.addAttribute("TypObj", neu);
		model.addAttribute("message2", message);
		
		return "ci-typ";//aktuelles Passwort ist falsch
	}
	
	
	@ExceptionHandler(PasswordsDoNotMatchException.class)
	public String handleException(Model model, PasswordsDoNotMatchException ex){

		String message = "Nachricht";
		CiType neu = new CiType();
		
		model.addAttribute("TypObj", neu);
		model.addAttribute("message2", message);
		
		return "ci-typ";//Neue Passwörter stimmen nicht überein
	}
	
	@ExceptionHandler(PasswortfeldLeerException.class)
	public String handleException(Model model, PasswortfeldLeerException ex){

		String message = "Nachricht";
		CiType neu = new CiType();
		
		model.addAttribute("TypObj", neu);
		model.addAttribute("message2", message);
		
		return "ci-typ";//Passwordfelf hat keinen Wert
		//kann ja eigentlich für neu und alt genommen werden, oder?
	}
	
	
	@ExceptionHandler(UserCanNotBeDeletedException.class)
	public String handleException(Model model, UserCanNotBeDeletedException ex){

		String message = "Nachricht";
		CiType neu = new CiType();
		
		model.addAttribute("TypObj", neu);
		model.addAttribute("message", message);
		
		return "ci-typ";//User der gelöscht werden soll existiert nicht
	}
	
	
	@ExceptionHandler(NewPasswordCanNotBEmptyException.class)
	public String handleException(Model model, NewPasswordCanNotBEmptyException ex){

		String message = "Nachricht";
		CiType neu = new CiType();
		
		model.addAttribute("TypObj", neu);
		model.addAttribute("message", message);
		
		return "ci-typ";//Passwordcheck für leeren benutzer
		
	}
}
