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
import com.gruppezwei.zero1one.repository.Attribut;
import com.gruppezwei.zero1one.repository.AttributRepository;
import com.gruppezwei.zero1one.repository.Attributtyp;
import com.gruppezwei.zero1one.repository.AttributtypRepository;
import com.gruppezwei.zero1one.repository.Configitem;
import com.gruppezwei.zero1one.repository.ConfigitemRepository;
import com.gruppezwei.zero1one.repository.Configitemtyp;
import com.gruppezwei.zero1one.repository.ConfigitemtypRepository;

/**
 * Dieser Manager bietet Methoden zum Aktualisieren von bereits bestehenden
 * Objekten in einer Datenbank.
 * 
 * @author wellvalour
 *
 */
@Component
public class UpdateManager {

	@Autowired
	ConfigitemtypRepository confTypRepo;

	@Autowired
	ConfigitemRepository confItemRepo;

	@Autowired
	AttributRepository attributRepo;

	@Autowired
	AttributtypRepository attTypRepo;

	/**
	 * Aktualisiert eine Liste von CiRecord mit allen ihren Attributen
	 */
	public void updateConfigItemMitAttributen(List<CiRecord> ciRecord) {
		confItemRepo.saveAll(ciRecord
				.stream()
				.map(this::convertToConfigItemMitAttributenUpdate)
				.collect(Collectors.toList()));
	}

	/**
	 * Updated alle Attribute
	 */
	private void updateAttribut(List<Attribute> attribute) {
		attributRepo.saveAll(attribute.stream().map(this::convertToAttribut).collect(Collectors.toList()));
	}

	/**
	 * Aktualisiert zu bestehenden CiTypen die Attributypen
	 * Überschreibt Attributtypen mit gelicher ID
	 */
	public void updateConfigItemTypeMitAttributen(List<CiType> ciType) {
		confTypRepo
				.saveAll(ciType.stream().map(this::convertToConfigItemTypMitAttributen).collect(Collectors.toList()));
	}

	/**
	 * Überschreibt Attributtypen mit gleicher ID
	 */
	private void updateAttributtyp(List<Attributtypen> typen) {
		attTypRepo.saveAll(typen.stream().map(this::convertToAttributtyp).collect(Collectors.toList()));
	}

//	
//	
//	
//	Here starts the dark realm!
//	You don't want to go down there!
//	(ab hier kommen alle Mapping-Methoden)

	private Attribut convertToAttribut(Attribute a) {
		Attribut c = new Attribut();

		c.setAttributtypID(a.getAttributtyp());
		c.setConfigItemID(a.getCiRecordId());
		c.setWert(a.getWert());
		c.setId(a.getId());

		return c;
	}

	private Configitem convertToConfigItemMitAttributenUpdate(CiRecord t) {
		Configitem c = new Configitem();

		c.setName(t.getName());
		c.setConfigItemTypname(t.getCiTyp());
		c.setId(t.getId());

		for (Attribute at : t.getAttribute()) {

			List<Attribute> atl = new ArrayList<Attribute>();

			atl.add(at);

			updateAttribut(atl);
		}

		return c;
	}

	private Configitemtyp convertToConfigItemTypMitAttributen(CiType t) {
		Configitemtyp c = new Configitemtyp();

		c.setName(t.getName());

		for (Attributtypen at : t.getTypen()) {
			List<Attributtypen> atl = new ArrayList<Attributtypen>();
			atl.add(at);
			updateAttributtyp(atl);
		}

		return c;
	}

	private Attributtyp convertToAttributtyp(Attributtypen a) {
		Attributtyp c = new Attributtyp();

		c.setName(a.getName());
		c.setConfigItemTypname(a.getConfigItemTyp());

		return c;
	}
}
