package com.gruppezwei.zero1one.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributRepository extends JpaRepository<Attribut, Integer> {

	public List<Attribut> findByConfigitemid(int configitemid); 
	
	public List<Attribut>  findTopByOrderByIdDesc();
}
