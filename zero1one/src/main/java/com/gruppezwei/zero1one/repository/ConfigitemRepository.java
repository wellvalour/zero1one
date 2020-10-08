package com.gruppezwei.zero1one.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigitemRepository extends JpaRepository<Configitem, Long> {
	
//	List<Configitem> findByName(String name);
//	
//	List<Configitem> findByConfigItemTypname(String configitemtypname);
}
