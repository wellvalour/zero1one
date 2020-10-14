package com.gruppezwei.zero1one.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributtypRepository extends JpaRepository<Attributtyp, Long> {
	
	List<Attributtyp> findByConfigitemtypname(String configitemtypname);
	
}
