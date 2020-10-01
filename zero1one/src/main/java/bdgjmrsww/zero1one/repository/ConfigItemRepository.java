package bdgjmrsww.zero1one.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigItemRepository extends JpaRepository<Mitarbeiter, Long> {
	
	List<Mitarbeiter> findByNachname(String nachname);
	
}
