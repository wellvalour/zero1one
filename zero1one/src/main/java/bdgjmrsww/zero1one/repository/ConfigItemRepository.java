package bdgjmrsww.zero1one.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigItemRepository extends JpaRepository<Mitarbeiter, Long> {
	
	Mitarbeiter findByNachname(String nachname);
	
}
