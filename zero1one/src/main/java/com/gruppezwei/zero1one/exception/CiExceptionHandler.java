package com.gruppezwei.zero1one.exception;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gruppezwei.zero1one.controller.CiSearch;
import com.gruppezwei.zero1one.controller.CiTypObjekt;
import com.gruppezwei.zero1one.controller.CiType;
import com.gruppezwei.zero1one.controller.HomeController;
import com.gruppezwei.zero1one.controller.Name;
import com.gruppezwei.zero1one.controller.Passwort;
import com.gruppezwei.zero1one.controller.UserObjekt;
import com.gruppezwei.zero1one.manager.AuthenticationManager;
import com.gruppezwei.zero1one.manager.ReadManager;
import com.gruppezwei.zero1one.repository.User;


@ControllerAdvice
public class CiExceptionHandler {

	@Autowired
	ReadManager lesen;
	
	@Autowired
	AuthenticationManager user;
	
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
		String nameAlt = HomeController.getUser();
		Name nameObj = new Name();
		nameObj.setNameAlt(HomeController.getUser());
		
		Passwort PWObj = new Passwort();
		
		UserObjekt UserObj = new UserObjekt();
		
		List<String> userList = user.getAllUsernames(); 
		User loeschObj = new User();
		
		String Uname = HomeController.getUser();
		
		model.addAttribute("nameAlt", nameAlt);
		model.addAttribute("nameObj", nameObj);
		model.addAttribute("PWObj", PWObj);
		model.addAttribute("UserObj", UserObj);
		model.addAttribute("userList", userList);
		model.addAttribute("loeschObj", loeschObj);
		model.addAttribute("name", Uname);
		model.addAttribute("message3", message);
		
		return "profil1";// Beim user anlegen  wird im manager geworfen
	}
	
	
	@ExceptionHandler(FieldCanNotBeEmptyException1.class)
	public String handleException1(Model model, FieldCanNotBeEmptyException1 ex){

		if(user.getUserByName(HomeController.getUser()).get(0).getBerechtigungsID() == 1) {
			String message = "Benutzername darf nicht leer sein";
			String nameAlt = HomeController.getUser();
			Name nameObj = new Name();
			nameObj.setNameAlt(HomeController.getUser());
			
			Passwort PWObj = new Passwort();
			
			UserObjekt UserObj = new UserObjekt();
			
			List<String> userList = user.getAllUsernames(); 
			User loeschObj = new User();
			
			String Uname = HomeController.getUser();
			
			model.addAttribute("nameAlt", nameAlt);
			model.addAttribute("nameObj", nameObj);
			model.addAttribute("PWObj", PWObj);
			model.addAttribute("UserObj", UserObj);
			model.addAttribute("userList", userList);
			model.addAttribute("loeschObj", loeschObj);
			model.addAttribute("name", Uname);
			model.addAttribute("message1", message);
			
			return "profil1";
			
		}else {
		
			String message = "Benutzername darf nicht leer sein";
			String nameAlt = HomeController.getUser();
			Name nameObj = new Name();
			nameObj.setNameAlt(HomeController.getUser());
			
			Passwort PWObj = new Passwort();
			
			String Uname = HomeController.getUser();
			
			model.addAttribute("nameAlt", nameAlt);
			model.addAttribute("nameObj", nameObj);
			model.addAttribute("PWObj", PWObj);
			model.addAttribute("name", Uname);
			model.addAttribute("message1", message);
			
			return "profil2";
		}
	}
	
	@ExceptionHandler(UserPasswordException.class)
	public String handleException(Model model, UserPasswordException ex){

		if(user.getUserByName(HomeController.getUser()).get(0).getBerechtigungsID() == 1) {
			
			String message = "Aktuelles Passwort ist nicht korrekt";
			String nameAlt = HomeController.getUser();
			Name nameObj = new Name();
			nameObj.setNameAlt(HomeController.getUser());
			
			Passwort PWObj = new Passwort();
			
			UserObjekt UserObj = new UserObjekt();
			
			List<String> userList = user.getAllUsernames(); 
			User loeschObj = new User();
			
			String Uname = HomeController.getUser();
			
			model.addAttribute("nameAlt", nameAlt);
			model.addAttribute("nameObj", nameObj);
			model.addAttribute("PWObj", PWObj);
			model.addAttribute("UserObj", UserObj);
			model.addAttribute("userList", userList);
			model.addAttribute("loeschObj", loeschObj);
			model.addAttribute("name", Uname);
			model.addAttribute("message2", message);
			
			return "profil1";
			
		}else {
		
		String message = "Aktuelles Passwort ist nicht korrekt";
		String nameAlt = HomeController.getUser();
		Name nameObj = new Name();
		nameObj.setNameAlt(HomeController.getUser());
		
		Passwort PWObj = new Passwort();
		
		String Uname = HomeController.getUser();
		
		model.addAttribute("nameAlt", nameAlt);
		model.addAttribute("nameObj", nameObj);
		model.addAttribute("PWObj", PWObj);
		model.addAttribute("name", Uname);
		model.addAttribute("message2", message);
		
		return "profil2";//aktuelles Passwort ist falsch
		}
	}
	
	
	@ExceptionHandler(PasswordsDoNotMatchException.class)
	public String handleException(Model model, PasswordsDoNotMatchException ex){

		if(user.getUserByName(HomeController.getUser()).get(0).getBerechtigungsID() == 1) {
			String message = "Neues Passwort stimmt nicht überein";
			String nameAlt = HomeController.getUser();
			Name nameObj = new Name();
			nameObj.setNameAlt(HomeController.getUser());
			
			Passwort PWObj = new Passwort();
			
			UserObjekt UserObj = new UserObjekt();
			
			List<String> userList = user.getAllUsernames(); 
			User loeschObj = new User();
			
			String Uname = HomeController.getUser();
			
			model.addAttribute("nameAlt", nameAlt);
			model.addAttribute("nameObj", nameObj);
			model.addAttribute("PWObj", PWObj);
			model.addAttribute("UserObj", UserObj);
			model.addAttribute("userList", userList);
			model.addAttribute("loeschObj", loeschObj);
			model.addAttribute("name", Uname);
			model.addAttribute("message2", message);
			
			return "profil1";
			
		}else {
		
			String message = "Neues Passwort stimmt nicht überein";
			String nameAlt = HomeController.getUser();
			Name nameObj = new Name();
			nameObj.setNameAlt(HomeController.getUser());
			
			Passwort PWObj = new Passwort();
			
			String Uname = HomeController.getUser();
			
			model.addAttribute("nameAlt", nameAlt);
			model.addAttribute("nameObj", nameObj);
			model.addAttribute("PWObj", PWObj);
			model.addAttribute("name", Uname);
			model.addAttribute("message2", message);
			
			return "profil2";//Neue Passwörter stimmen nicht überei
		}
	}

	
	@ExceptionHandler(PasswortfeldLeerException.class)
	public String handleException(Model model, PasswortfeldLeerException ex){

		if(user.getUserByName(HomeController.getUser()).get(0).getBerechtigungsID() == 1) {
			
			String message = "Angaben unvollständig";
			String nameAlt = HomeController.getUser();
			Name nameObj = new Name();
			nameObj.setNameAlt(HomeController.getUser());
			
			Passwort PWObj = new Passwort();
			
			UserObjekt UserObj = new UserObjekt();
			
			List<String> userList = user.getAllUsernames(); 
			User loeschObj = new User();
			
			String Uname = HomeController.getUser();
			
			model.addAttribute("nameAlt", nameAlt);
			model.addAttribute("nameObj", nameObj);
			model.addAttribute("PWObj", PWObj);
			model.addAttribute("UserObj", UserObj);
			model.addAttribute("userList", userList);
			model.addAttribute("loeschObj", loeschObj);
			model.addAttribute("name", Uname);
			model.addAttribute("message2", message);
			
			return "profil1";
			
		}else {
		
			String message = "Angaben unvollständig";
			String nameAlt = HomeController.getUser();
			Name nameObj = new Name();
			nameObj.setNameAlt(HomeController.getUser());
			
			Passwort PWObj = new Passwort();
			
			String Uname = HomeController.getUser();
			
			model.addAttribute("nameAlt", nameAlt);
			model.addAttribute("nameObj", nameObj);
			model.addAttribute("PWObj", PWObj);
			model.addAttribute("name", Uname);
			model.addAttribute("message2", message);
		}
			
		return "profil2";//Passwordfelf hat keinen Wert
	}
	
	
	@ExceptionHandler(NewPasswordCanNotBEmptyException.class)
	public String handleException(Model model, NewPasswordCanNotBEmptyException ex){

		String message = "Angaben unvollständig";
		String nameAlt = HomeController.getUser();
		Name nameObj = new Name();
		nameObj.setNameAlt(HomeController.getUser());
		
		Passwort PWObj = new Passwort();
		
		UserObjekt UserObj = new UserObjekt();
		
		List<String> userList = user.getAllUsernames(); 
		User loeschObj = new User();
		
		String Uname = HomeController.getUser();
		
		model.addAttribute("nameAlt", nameAlt);
		model.addAttribute("nameObj", nameObj);
		model.addAttribute("PWObj", PWObj);
		model.addAttribute("UserObj", UserObj);
		model.addAttribute("userList", userList);
		model.addAttribute("loeschObj", loeschObj);
		model.addAttribute("name", Uname);
		model.addAttribute("message3", message);
		
		return "profil1";//Passwordcheck für leeren benutzer	
	}
	
	@ExceptionHandler(PasswordsDoNotMatchException2.class)
	public String handleException2(Model model, PasswordsDoNotMatchException2 ex){

			String message = "Neues Passwort stimmt nicht überein";
			String nameAlt = HomeController.getUser();
			Name nameObj = new Name();
			nameObj.setNameAlt(HomeController.getUser());
			
			Passwort PWObj = new Passwort();
			
			UserObjekt UserObj = new UserObjekt();
			
			List<String> userList = user.getAllUsernames(); 
			User loeschObj = new User();
			
			String Uname = HomeController.getUser();
			
			model.addAttribute("nameAlt", nameAlt);
			model.addAttribute("nameObj", nameObj);
			model.addAttribute("PWObj", PWObj);
			model.addAttribute("UserObj", UserObj);
			model.addAttribute("userList", userList);
			model.addAttribute("loeschObj", loeschObj);
			model.addAttribute("name", Uname);
			model.addAttribute("message3", message);
			
			return "profil1";
			
	}

	@ExceptionHandler(UserCanNotBeDeletedException.class)
	public String handleException(Model model, UserCanNotBeDeletedException ex){

		String message = ex.getMessage();
		String nameAlt = HomeController.getUser();
		Name nameObj = new Name();
		nameObj.setNameAlt(HomeController.getUser());
		
		Passwort PWObj = new Passwort();
		
		UserObjekt UserObj = new UserObjekt();
		
		List<String> userList = user.getAllUsernames(); 
		User loeschObj = new User();
		
		String Uname = HomeController.getUser();
		
		model.addAttribute("nameAlt", nameAlt);
		model.addAttribute("nameObj", nameObj);
		model.addAttribute("PWObj", PWObj);
		model.addAttribute("UserObj", UserObj);
		model.addAttribute("userList", userList);
		model.addAttribute("loeschObj", loeschObj);
		model.addAttribute("name", Uname);
		model.addAttribute("message4", message);
		
		return "profil1";//User der gelöscht werden soll existiert nicht
	}

}
