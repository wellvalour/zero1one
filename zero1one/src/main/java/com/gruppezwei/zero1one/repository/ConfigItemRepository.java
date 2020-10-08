package com.gruppezwei.zero1one.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigItemRepository extends JpaRepository<Configitem, Long> {
	
//	List<Configitem> findByName(String name);
//	
//	List<Configitem> findByConfigItemTypname(String configitemtypname);
}
