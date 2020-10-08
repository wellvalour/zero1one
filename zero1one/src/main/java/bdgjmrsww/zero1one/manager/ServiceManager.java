package bdgjmrsww.zero1one.manager;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bdgjmrsww.zero1one.controller.UnserTestobjekt;
import bdgjmrsww.zero1one.repository.ConfigItem;
import bdgjmrsww.zero1one.repository.ConfigItemRepository;
import bdgjmrsww.zero1one.repository.User;
import bdgjmrsww.zero1one.repository.UserRepository;

@Controller
public class ServiceManager {
	
	@Autowired
	ConfigItemRepository itemRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public List<UnserTestobjekt> getConfigItemGanz() {
		List<ConfigItem> item = itemRepo.findAll();

		List<UnserTestobjekt> testobj = item.stream().map(this::convertTestobjekt).collect(Collectors.toList());

		return testobj;
	}

	private UnserTestobjekt convertTestobjekt(ConfigItem i) {
		UnserTestobjekt u = new UnserTestobjekt();

		u.setEins(""+ i.getId());
		u.setZwei(i.getConfigItemTypname());
		u.setDrei(i.getName());

		return u;
	}
	
	public List<UnserTestobjekt> getUserGanz() {
		List<User> item = userRepo.findAll();

		List<UnserTestobjekt> testobj = item.stream().map(this::convertTestobjekt).collect(Collectors.toList());

		return testobj;
	}

	private UnserTestobjekt convertTestobjekt(User u) {
		UnserTestobjekt t = new UnserTestobjekt();

		t.setEins(""+ u.getName());
		t.setZwei(u.getPasswort());
		t.setDrei(""+ u.getBerechtigungsID());

		return t;
	}
}
