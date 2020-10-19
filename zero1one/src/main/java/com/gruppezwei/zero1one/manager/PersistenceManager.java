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

//	
//	Methoden zum Lesen aus der Datenbank
//	

	/**
	 * Liefert eine Liste aller CiTypen
	 */
	public List<CiType> getCiTypeAll() {
		return confTypRepo.findAll().stream().map(this::convertToCiType).collect(Collectors.toList());
	}
	
	/**
	 * Liefert eine Liste aller CiTypen als Strings
	 */
	public List<String> getCiTypeAsString() {
		return confTypRepo.findAll().stream().map(this::convertToString).collect(Collectors.toList());
	}
	
	/**
	 * Liefert eine Liste aller CiTypen inklusive der Attributtypen
	 */
	public List<CiType> getCiTypeMitAttributtypen() {
		return confTypRepo.findAll().stream().map(this::convertToCiTypeMitAttributtypen).collect(Collectors.toList());
	}
	
	/**
	 * Liefert eine Liste aller CiRecords zu einer ID
	 */
	public List<CiRecord> getCiRecordAll(int id) {
		return confItemRepo.findById(id).stream().map(this::convertToCiRecord).collect(Collectors.toList());
	}
	
	/**
	 * Liefert eine Liste aller CiRecords
	 */
	public List<CiRecord> getCiRecordByID(int id) {
		return confItemRepo.findAll().stream().map(this::convertToCiRecord).collect(Collectors.toList());
	}

	/**
	 * Liefert eine Liste aller Namen von CiTypen und CiRecords
	 */
	public List<String> getSuchbegriffeAll() {
		List<String> list = confTypRepo.findAll().stream().map(this::convertToString).collect(Collectors.toList());
		List<String> list2 = confItemRepo.findAll().stream().map(this::convertToString).collect(Collectors.toList());

		list.addAll(list2);

		return list;
	}

	/**
	 * Liefert alle CiRecords eines bestimmten CiTypes
	 * 
	 * @param type
	 */
	public List<CiRecord> getCiRecordByTyp(String type) {
		return confItemRepo.findByConfigitemtypname(type).stream().map(this::convertToCiRecord)
				.collect(Collectors.toList());
	}

	/**
	 * Liefert alle Attribute zu einem bestimmten CiRecord
	 * 
	 * @param record ist die Id des CiRecords
	 */
	public List<Attribute> getAttributToRecord(int record) {
		return attributRepo.findByConfigitemid(record).stream().map(this::convertToAttribute)
				.collect(Collectors.toList());
	}

	/**
	 * Liefert die größte Id auf der Tabelle ConfigItem
	 */
	public int getMaxIdCi() {
		return confItemRepo.findTopByOrderByIdDesc().stream().map(this::convertToCiRecord).collect(Collectors.toList())
				.get(0).getId();
	}

	/**
	 * Liefert alle Attributtypen
	 */
	public List<Attributtypen> getAttributTypGanz() {
		List<Attributtyp> item = attTypRepo.findAll();

		List<Attributtypen> testobj = item.stream().map(this::convertToAttributtypen).collect(Collectors.toList());

		return testobj;
	}

	/**
	 * Liefert alle Attributtypen zu einem CiTypen
	 */
	public List<Attributtypen> getAttributTypNachCiType(String type) {
		List<Attributtyp> item = attTypRepo.findByConfigitemtypname(type);

		List<Attributtypen> testobj = item.stream().map(this::convertToAttributtypen).collect(Collectors.toList());

		return testobj;
	}

//	
//	Methoden zum Speichern in der Datenbank
//	

	/**
	 * Speichert einen ConfigItemType in der Datenbank ab (Wird vermutlich nie
	 * benötigt)
	 */
	public void persistConfigItemTypeNurNamen(List<CiType> ciType) {
		confTypRepo.saveAll(ciType.stream().map(this::convertToConfigItemTyp).collect(Collectors.toList()));
	}

	/**
	 * Speichert einen ConfigItemType in der Datenbank mit allen Attributtypen ab
	 */
	public void persistConfigItemTypeMitAttributen(List<CiType> ciType) {
		confTypRepo
				.saveAll(ciType.stream().map(this::convertToConfigItemTypMitAttributen).collect(Collectors.toList()));
	}

	/**
	 * Speichert einen ConfigItem in der Datenbank ab (Wird vermutlich nie
	 * benötigt)
	 */
	public void persistConfigItem(List<CiRecord> ciRecord) {
		confItemRepo.saveAll(ciRecord.stream().map(this::convertToConfigItem).collect(Collectors.toList()));
	}
	
	/**
	 * Speichert einen neues ConfigItem mit allen Attributen in der Datenbank ab. Es wird automatisch eine ID für den CiRecord ermittelt
	 */
	public void persistConfigItemMitAttributen(List<CiRecord> ciRecord) {
		confItemRepo.saveAll(ciRecord.stream().map(this::convertToConfigItemMitAttributen).collect(Collectors.toList()));
	}

	/**
	 * Speichert einen Attribut in der Datenbank ab
	 */
	public void persistAttribut(List<Attribute> ciRecord) {
		attributRepo.saveAll(ciRecord.stream().map(this::convertToAttribut).collect(Collectors.toList()));
	}

	/**
	 * Speichert einen Attributtyp in der Datenbank ab
	 */
	public void persistAttributtyp(List<Attributtypen> typen) {
		attTypRepo.saveAll(typen.stream().map(this::convertToAttributtyp).collect(Collectors.toList()));
	}

	
	
	
	
	
	
	
//	
//	
//	
//	Here starts the dark realm!
//	You don't want to go down there!
//	(ab hier kommen alle Mapping-Methoden)

	private CiType convertToCiType(Configitemtyp i) {
		CiType o = new CiType();

		o.setName(i.getName());

		return o;
	}
	
	private CiType convertToCiTypeMitAttributtypen(Configitemtyp i) {
		CiType o = new CiType();

		o.setName(i.getName());
		o.setTypen(getAttributTypNachCiType(o.getName()));

		return o;
	}

	private CiRecord convertToCiRecord(Configitem i) {
		CiRecord o = new CiRecord();

		o.setId(i.getId());
		o.setName(i.getName());
		o.setAttribute(getAttributToRecord(i.getId()));

		return o;
	}

	private Attribute convertToAttribute(Attribut i) {
		Attribute o = new Attribute();

		o.setAttributtyp(i.getAttributtypID());
		o.setWert(i.getWert());

		return o;
	}

	private String convertToString(Configitemtyp i) {
		return i.getName();
	}

	private String convertToString(Configitem i) {
		return i.getName();
	}

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

	private Attributtypen convertToAttributtypen(Attributtyp i) {
		Attributtypen o = new Attributtypen();

		o.setName(i.getName());
		o.setConfigItemTyp(i.getConfigItemTypname());
		return o;
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
		int CiId = confItemRepo.findTopByOrderByIdDesc().get(0).getId() +1;// Ermittelt neue ID für Record
		c.setId(CiId);
		
		for (Attribute at : t.getAttribute()) {
			
			List<Attribute> atl = new ArrayList<Attribute>();
			
			List<Attribut> list = attributRepo.findTopByOrderByIdDesc(); 	//Liest höchste aktuelle ID
			int neueId = list.get(0).getId() +1; 							//Legt neue höchste ID fest
			
			at.setId(neueId);
			at.setCiRecordId(CiId);
			
			atl.add(at);
			
			persistAttribut(atl);
		}
		
		
		return c;
	}
	
}
