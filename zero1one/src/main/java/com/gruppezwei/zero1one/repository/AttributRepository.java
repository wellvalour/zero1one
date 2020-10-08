package com.gruppezwei.zero1one.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributRepository extends JpaRepository<Attribut, Long> {

}
