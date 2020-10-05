package bdgjmrsww.zero1one.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstanzRepository extends JpaRepository<Instanz, Long> {
		
		List<Instanz> findByName(String name);
		
		List<Instanz> findByConfigItemTypname(String configItemTypname);
}
