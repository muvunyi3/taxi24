package org.taxi24.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.taxi24.api.model.Drivers;

@Repository
public interface DriversRepository extends JpaRepository<Drivers, Long> {
	@Query(value ="insert into Drivers(id,fname, lname, phone,email, doc_type, doc_number, license, status) values (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9)", nativeQuery = true)
	public void insertDriver(Long id, String firstName, String lastName, String phone, String email, String docType,String docNumber,String license, boolean status );
		
}
