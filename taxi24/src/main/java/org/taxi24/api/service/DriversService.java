package org.taxi24.api.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.taxi24.api.model.Drivers;
import org.taxi24.api.model.Locations;

@Component 
public interface DriversService {
	
	public List<Drivers> list();
	
	public Drivers create(Drivers driver);
	
	public Drivers get(Long id);	

	public Drivers closestDrivers(Locations location);

	public Drivers closestToRiders(String locName);
}
