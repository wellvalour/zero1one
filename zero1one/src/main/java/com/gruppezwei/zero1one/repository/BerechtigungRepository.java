package com.gruppezwei.zero1one.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BerechtigungRepository extends JpaRepository<Berechtigung, Integer> {
	
	List<Berechtigung> findById(int id);
	
}
