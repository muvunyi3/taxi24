package org.taxi24.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.taxi24.api.model.Trips;
@Repository
public interface TripsRepository extends JpaRepository<Trips, Long> {

	public List<Trips> findByStatus(boolean status);
}
