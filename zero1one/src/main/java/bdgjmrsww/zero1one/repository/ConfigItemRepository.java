package bdgjmrsww.zero1one.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigItemRepository extends JpaRepository<ConfigItem, Long> {
	
	List<ConfigItem> findByName(String name);
	
	List<ConfigItem> findByConfigItemTypname(String configItemTypname);
}
