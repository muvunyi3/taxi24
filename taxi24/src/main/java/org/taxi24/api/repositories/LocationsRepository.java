package org.taxi24.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.taxi24.api.model.Locations;
@Repository
public interface LocationsRepository extends JpaRepository<Locations, Long> {
	@Query("select  l from Locations l where l.id in (select max (id) from Locations  group by driver_fk)")
	public List<Locations> findLastLocationsByDriver();
}
