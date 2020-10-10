package com.gruppezwei.zero1one.manager;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gruppezwei.zero1one.controller.Attribute;
import com.gruppezwei.zero1one.controller.CiRecord;
import com.gruppezwei.zero1one.controller.CiType;
import com.gruppezwei.zero1one.repository.Attribut;
import com.gruppezwei.zero1one.repository.AttributRepository;
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
	
	
	/**
	 * Liefert eine Liste aller CiTypen
	 */
	public List<CiType> getCiTypeAll() {
		return confTypRepo.findAll().stream().map(this::convertToCiType).collect(Collectors.toList());
	}
	
	/**
	 * Liefert eine Liste aller CiRecords
	 */
	public List<CiRecord> getCiRecordAll(){
		return confItemRepo.findAll().stream().map(this::convertToCiRecord).collect(Collectors.toList());
	}
	
	/**
	 * Liefert eine Liste aller Namen von CiTypen und CiRecords
	 */
	public List<String> getSuchbegriffeAll(){
		List<String> list = confTypRepo.findAll().stream().map(this::convertToString).collect(Collectors.toList());
		List<String> list2 = confItemRepo.findAll().stream().map(this::convertToString).collect(Collectors.toList());
		
		list.addAll(list2);
		
		return list;
	}
	
	/**
	 * Liefert alle CiRecords eines bestimmten CiTypes
	 * @param type
	 */
	public List<CiRecord> getCiRecordByTyp(String type){
		return confItemRepo.findByConfigitemtypname(type).stream().map(this::convertToCiRecord).collect(Collectors.toList());
	}
	
	/**
	 * Liefert alle Attribute zu einem bestimmten CiRecord
	 * @param record ist die Id des CiRecords
	 */
	public List<Attribute> getAttributToRecord(int record) {
		return attributRepo.findByConfigitemid(record).stream().map(this::convertToAttribute).collect(Collectors.toList());
	}
	
	
	
	
	
	//Here starts the dark realm!
	
	private CiType convertToCiType(Configitemtyp i) {
		CiType o = new CiType();

		o.setName(i.getName());

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
}
