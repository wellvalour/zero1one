package bdgjmrsww.zero1one.manager;

import org.springframework.stereotype.Controller;

@Controller
public class ServiceManagerMitarbeiter {

//	@Autowired
//	private ConfigItemRepository repo;

//	public List<UnserTestobjekt> getMitarbeiterByName(String name) {
//		List<Mitarbeiter> mitarbeiter = repo.findByNachname(name);
//
//		List<UnserTestobjekt> testobj = mitarbeiter.stream().map(this::convertTestobjekt).collect(Collectors.toList());
//
//		return testobj;
//	}
//
//	public List<UnserTestobjekt> getMitarbeiterGanz() {
//		List<Mitarbeiter> mitarbeiter = repo.findAll();
//
//		List<UnserTestobjekt> testobj = mitarbeiter.stream().map(this::convertTestobjekt).collect(Collectors.toList());
//
//		return testobj;
//	}
//
//	private UnserTestobjekt convertTestobjekt(Mitarbeiter m) {
//		UnserTestobjekt u = new UnserTestobjekt();
//
//		u.setEins("" + m.getPersnr());
//		u.setZwei(m.getNachname());
//		u.setDrei(m.getVorname());
//		u.setVier(m.getBeruf());
//		u.setFuenf("" + m.getGehalt());
//
//		return u;
//	}
}
