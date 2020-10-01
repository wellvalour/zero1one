package bdgjmrsww.zero1one.manager;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bdgjmrsww.zero1one.controller.UnserTestobjekt;
import bdgjmrsww.zero1one.repository.Instanz;
import bdgjmrsww.zero1one.repository.InstanzRepository;

@Controller
public class ServiceManager {
	
	@Autowired
	InstanzRepository instanzRepo;
	
	public List<UnserTestobjekt> getInstanzGanz() {
		List<Instanz> mitarbeiter = instanzRepo.findAll();

		List<UnserTestobjekt> testobj = mitarbeiter.stream().map(this::convertTestobjekt).collect(Collectors.toList());

		return testobj;
	}

	private UnserTestobjekt convertTestobjekt(Instanz i) {
		UnserTestobjekt u = new UnserTestobjekt();

		u.setEins(""+ i.getId());
		u.setZwei(i.getConfigItemTypname());
		u.setDrei(i.getName());

		return u;
	}
}
