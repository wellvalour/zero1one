package com.gruppezwei.zero1one.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigitemRepository extends JpaRepository<Configitem, Integer> {
	
	List<Configitem> findByName(String name);
	
	List<Configitem> findByConfigitemtypname(String configitemtypname);
	
	List<Configitem>  findTopByOrderByIdDesc();
}
