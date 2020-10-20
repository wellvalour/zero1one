package com.gruppezwei.zero1one.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gruppezwei.zero1one.controller.Attribute;
import com.gruppezwei.zero1one.controller.Attributtypen;
import com.gruppezwei.zero1one.controller.CiRecord;
import com.gruppezwei.zero1one.controller.CiType;
import com.gruppezwei.zero1one.exception.ObjektAllreadyExistsException;
import com.gruppezwei.zero1one.repository.Attribut;
import com.gruppezwei.zero1one.repository.AttributRepository;
import com.gruppezwei.zero1one.repository.Attributtyp;
import com.gruppezwei.zero1one.repository.AttributtypRepository;
import com.gruppezwei.zero1one.repository.Configitem;
import com.gruppezwei.zero1one.repository.ConfigitemRepository;
import com.gruppezwei.zero1one.repository.Configitemtyp;
import com.gruppezwei.zero1one.repository.ConfigitemtypRepository;

/**
 * Dieser Manager bietet Methoden zum Speicher von neuen Objekten in einer Datenbank.
 * 
 * @author wellvalour
 *
 */
@Component
public class PersistenceManager {

	@Autowired
	ConfigitemtypRepository confTypRepo;

	@Autowired
	ConfigitemRepository confItemRepo;

	@Autowired
	AttributRepository attributRepo;

	@Autowired
	AttributtypRepository attTypRepo;


	/**
	 * Speichert einen ConfigItemType in der Datenbank ab (Wird vermutlich nie
	 * benötigt)
	 */
	public void persistConfigItemTypeNurNamen(List<CiType> ciType) {
		if(confTypRepo.existsById(ciType.get(0).getName())){
			throw new ObjektAllreadyExistsException();
		}
		confTypRepo.saveAll(ciType.stream().map(this::convertToConfigItemTyp).collect(Collectors.toList()));
	}

	/**
	 * Speichert einen ConfigItemType in der Datenbank mit allen Attributtypen ab
	 */
	public void persistConfigItemTypeMitAttributen(List<CiType> ciType) {
		if(confTypRepo.existsById(ciType.get(0).getName())){
			throw new ObjektAllreadyExistsException();
		}
		confTypRepo
				.saveAll(ciType.stream().map(this::convertToConfigItemTypMitAttributen).collect(Collectors.toList()));
	}

	/**
	 * Speichert einen ConfigItem in der Datenbank ab (Wird vermutlich nie benötigt)
	 */
	public void persistConfigItem(List<CiRecord> ciRecord) {
		confItemRepo.saveAll(ciRecord.stream().map(this::convertToConfigItem).collect(Collectors.toList()));
	}

	/**
	 * Speichert einen neues ConfigItem mit allen Attributen in der Datenbank ab. Es
	 * wird automatisch eine ID für den CiRecord ermittelt
	 */
	public void persistConfigItemMitAttributen(List<CiRecord> ciRecord) {
		confItemRepo
				.saveAll(ciRecord.stream().map(this::convertToConfigItemMitAttributen).collect(Collectors.toList()));
	}

	/**
	 * Speichert einen Attribut in der Datenbank ab
	 */
	private void persistAttribut(List<Attribute> attribute) {
		attributRepo.saveAll(attribute.stream().map(this::convertToAttribut).collect(Collectors.toList()));
	}

	/**
	 * Speichert einen Attributtyp in der Datenbank ab
	 */
	private void persistAttributtyp(List<Attributtypen> typen) {
		attTypRepo.saveAll(typen.stream().map(this::convertToAttributtyp).collect(Collectors.toList()));
	}

//	
//	
//	
//	Here starts the dark realm!
//	You don't want to go down there!
//	(ab hier kommen alle Mapping-Methoden)

	private Configitemtyp convertToConfigItemTyp(CiType t) {
		Configitemtyp c = new Configitemtyp();

		c.setName(t.getName());

		return c;
	}

	private Configitem convertToConfigItem(CiRecord t) {
		Configitem c = new Configitem();

		c.setName(t.getName());
		c.setConfigItemTypname(t.getCiTyp());
		c.setId(t.getId());

		return c;
	}

	private Configitemtyp convertToConfigItemTypMitAttributen(CiType t) {
		Configitemtyp c = new Configitemtyp();

		c.setName(t.getName());

		for (Attributtypen at : t.getTypen()) {
			List<Attributtypen> atl = new ArrayList<Attributtypen>();
			atl.add(at);
			persistAttributtyp(atl);
		}

		return c;
	}

	private Attributtyp convertToAttributtyp(Attributtypen a) {
		Attributtyp c = new Attributtyp();

		c.setName(a.getName());
		c.setConfigItemTypname(a.getConfigItemTyp());

		return c;
	}

	private Attribut convertToAttribut(Attribute a) {
		Attribut c = new Attribut();

		c.setAttributtypID(a.getAttributtyp());
		c.setConfigItemID(a.getCiRecordId());
		c.setWert(a.getWert());
		c.setId(a.getId());

		return c;
	}

	private Configitem convertToConfigItemMitAttributen(CiRecord t) {
		Configitem c = new Configitem();

		c.setName(t.getName());
		c.setConfigItemTypname(t.getCiTyp());
		int CiId = confItemRepo.findTopByOrderByIdDesc().get(0).getId() + 1;// Ermittelt neue ID für Record
		c.setId(CiId);

		System.out.println(CiId);

		for (Attribute at : t.getAttribute()) {

			List<Attribute> atl = new ArrayList<Attribute>();

			List<Attribut> list = attributRepo.findTopByOrderByIdDesc(); // Liest höchste aktuelle ID
			int neueId = list.get(0).getId() + 1; // Legt neue höchste ID fest

			System.out.println(neueId);

			at.setId(neueId);
			at.setCiRecordId(CiId);

			atl.add(at);

			persistAttribut(atl);
		}

		return c;
	}
}
