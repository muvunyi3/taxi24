package org.taxi24.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.taxi24.api.model.Riders;
@Repository
public interface RidersRepository extends JpaRepository<Riders, Long> {

}
