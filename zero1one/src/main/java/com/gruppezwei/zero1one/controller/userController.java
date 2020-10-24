package com.gruppezwei.zero1one.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gruppezwei.zero1one.exception.FieldCanNotBeEmptyException1;
import com.gruppezwei.zero1one.exception.NewPasswordCanNotBEmptyException;
import com.gruppezwei.zero1one.exception.PasswordsDoNotMatchException;
import com.gruppezwei.zero1one.exception.PasswordsDoNotMatchException2;
import com.gruppezwei.zero1one.exception.PasswortfeldLeerException;
import com.gruppezwei.zero1one.exception.UserPasswordException;
import com.gruppezwei.zero1one.manager.AuthenticationManager;
import com.gruppezwei.zero1one.manager.ReadManager;
import com.gruppezwei.zero1one.repository.User;

@SpringBootApplication
@Controller
public class userController {

	@Autowired
	AuthenticationManager user;

	@Autowired
	ReadManager lesen;

	@GetMapping(value = "/profil", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getData(Model model) {

		if (user.getUserByName(HomeController.getUser()).get(0).getBerechtigungsID() == 1) {

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

			return "profil1";

		} else {
			String nameAlt = HomeController.getUser();
			Name nameObj = new Name();
			nameObj.setNameAlt(HomeController.getUser());

			Passwort PWObj = new Passwort();

			String Uname = HomeController.getUser();

			model.addAttribute("nameAlt", nameAlt);
			model.addAttribute("nameObj", nameObj);
			model.addAttribute("PWObj", PWObj);
			model.addAttribute("name", Uname);

			return "profil2";
		}
	}

	@PostMapping(value = "/profil/Name-Aendern", consumes = { MediaType.ALL_VALUE }, produces = {
			MediaType.TEXT_HTML_VALUE })
	public String getAttributeToType(@ModelAttribute Name nameObj, Model model) {

		if (nameObj.getNameNeu().isEmpty()) {
			throw new FieldCanNotBeEmptyException1();
		} else {
			user.changeUsername(HomeController.getUser(), nameObj.getNameNeu());
			HomeController.setUser(nameObj.getNameNeu());

			List<CiType> TypObj = lesen.getCiTypeAll();
			List<CiRecord> SeaListRec = lesen.getCiRecordAll();
			String Uname = HomeController.getUser();

			model.addAttribute("type", TypObj);
			model.addAttribute("suchliste", SeaListRec);
			model.addAttribute("suche", new CiSearch());
			model.addAttribute("name", Uname);
		}
		return "dashboard/record";
	}

	@PostMapping(value = "/profil/PW-Aendern", consumes = { MediaType.ALL_VALUE }, produces = {
			MediaType.TEXT_HTML_VALUE })
	public String setNewPasswort(@ModelAttribute Passwort PWObj, Model model) {

		if (PWObj.getPWNeu().isEmpty() || PWObj.getPWNeuWdh().isEmpty() || PWObj.getPWAlt().isEmpty()) {
			throw new PasswortfeldLeerException();
		}

		String PW1 = "" + PWObj.getPWAlt().hashCode();
		PWObj.setPWAlt(PW1);
		String PW2 = "" + PWObj.getPWNeu().hashCode();
		PWObj.setPWNeu(PW2);
		String PW3 = "" + PWObj.getPWNeuWdh().hashCode();
		PWObj.setPWNeuWdh(PW3);

		if (!PWObj.getPWNeu().equals(PWObj.getPWNeuWdh())) {
			throw new PasswordsDoNotMatchException();
		}

		if (PWObj.getPWAlt().equals(user.getUserByName(HomeController.getUser()).get(0).getPasswort())) {
			List<User> UserListPW = user.getUserByName(HomeController.getUser());
			User neuUserPW = UserListPW.get(0);
			neuUserPW.setPasswort(PWObj.getPWNeu());
			user.changePassword(neuUserPW);
		} else {
			throw new UserPasswordException();
		}

		List<CiType> TypObj = lesen.getCiTypeAll();
		List<CiRecord> SeaListRec = lesen.getCiRecordAll();
		String Uname = HomeController.getUser();

		model.addAttribute("type", TypObj);
		model.addAttribute("suchliste", SeaListRec);
		model.addAttribute("suche", new CiSearch());
		model.addAttribute("name", Uname);

		return "dashboard/record";
	}

	@PostMapping(value = "/profil/Nutzer-Anlegen", consumes = { MediaType.ALL_VALUE }, produces = {
			MediaType.TEXT_HTML_VALUE })
	public String setNewUser(@ModelAttribute UserObjekt UserObj, Model model) {

		if (UserObj.getPWNeu().isEmpty() || UserObj.getPWNeuWdh().isEmpty()) {
			throw new NewPasswordCanNotBEmptyException();
		}

		String PW2 = "" + UserObj.getPWNeu().hashCode();
		UserObj.setPWNeu(PW2);
		String PW3 = "" + UserObj.getPWNeuWdh().hashCode();
		UserObj.setPWNeuWdh(PW3);
		if (UserObj.getPWNeu().equals(UserObj.getPWNeuWdh())) {
			User neuUser = new User();
			neuUser.setPasswort(UserObj.getPWNeu());
			neuUser.setName(UserObj.getName());
			if (UserObj.getBerechtigung().equals("Admin")) {
				neuUser.setBerechtigungsID(1);
			} else {
				neuUser.setBerechtigungsID(0);
			}
			user.userAnlegen(neuUser);
		} else {
			throw new PasswordsDoNotMatchException2();
		}

		List<CiType> TypObj = lesen.getCiTypeAll();
		List<CiRecord> SeaListRec = lesen.getCiRecordAll();
		String Uname = HomeController.getUser();

		model.addAttribute("type", TypObj);
		model.addAttribute("suchliste", SeaListRec);
		model.addAttribute("suche", new CiSearch());
		model.addAttribute("name", Uname);

		return "dashboard/record";
	}

	@PostMapping(value = "/profil/Nutzer-Loeschen", consumes = { MediaType.ALL_VALUE }, produces = {
			MediaType.TEXT_HTML_VALUE })
	public String setNewUser(@ModelAttribute User loeschUser, Model model) {

		user.deleteUserById(loeschUser.getName());

		List<CiType> TypObj = lesen.getCiTypeAll();
		List<CiRecord> SeaListRec = lesen.getCiRecordAll();
		String Uname = HomeController.getUser();

		model.addAttribute("type", TypObj);
		model.addAttribute("suchliste", SeaListRec);
		model.addAttribute("suche", new CiSearch());
		model.addAttribute("name", Uname);

		return "dashboard/record";
	}

	@GetMapping(value = "/hilfe", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
	public String getHelp(Model model) {

		return "hilfe";
	}

}
