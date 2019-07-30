package org.taxi24.api.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.taxi24.api.model.Locations;

@Component
public interface LocationsService {
	
	public List<Locations> list();

	public Locations create(Locations locations);
	
	public List<Locations> getLastLoc();
}
