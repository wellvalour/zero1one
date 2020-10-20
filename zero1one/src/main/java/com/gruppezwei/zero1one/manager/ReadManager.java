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
 * Dieser Manager bietet Methoden zum Lesen aus einer Datenbank.
 * 
 * @author wellvalour
 *
 */
@Component
public class ReadManager {

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
	 * Liefert eine Liste aller CiRecords
	 */
	public List<CiRecord> getCiRecordAll() {
		return confItemRepo.findAll().stream().map(this::convertToCiRecord).collect(Collectors.toList());
	}

	/**
	 * Liefert eine Liste aller CiRecords zu einer ID
	 */
	public List<CiRecord> getCiRecordByID(int id) {
		return confItemRepo.findById(id).stream().map(this::convertToCiRecord).collect(Collectors.toList());
	}
	
	/**
	 * Liefert ein CiRecords zu einer ID
	 */
	public CiRecord getSingleCiRecordByID(int id) {
		return confItemRepo.findById(id).stream().map(this::convertToCiRecord).collect(Collectors.toList()).get(0);
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
	
	/**
	 * Liefert zu einem CiTyp alle Attributtypen nach ihrer ID
	 * @param name
	 */
	public List<String> getAttributTypIDtoCiType(String name){
		List<Attributtyp> attyp = attTypRepo.findByConfigitemtypname(name);
		List<String> ids = new ArrayList<String>();
		
		for(Attributtyp a : attyp) {
			ids.add(a.getName());
		}
		
		return ids;
	}
	
	/**
	 * Liefert zu einem CiRecord alle Attribute nach ihrer ID
	 * @param name
	 */
	public List<Integer> getAttributIDtoCiRecord(int RecId){
		List<Attribut> attyp = attributRepo.findByConfigitemid(RecId);
		List<Integer> ids = new ArrayList<Integer>();
		
		for(Attribut a : attyp) {
			ids.add(a.getId());
		}
		
		return ids;
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

	private Attributtypen convertToAttributtypen(Attributtyp i) {
		Attributtypen o = new Attributtypen();

		o.setName(i.getName());
		o.setConfigItemTyp(i.getConfigItemTypname());
		return o;
	}
}
