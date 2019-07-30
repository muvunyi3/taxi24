package org.taxi24.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taxi24.api.model.Locations;
import org.taxi24.api.repositories.LocationsRepository;

@Service
public class LocationsServiceImp implements LocationsService {

	@Autowired
	LocationsRepository locationsRepository;
	@Override
	public List<Locations> list() {
		return locationsRepository.findAll();
	}

	@Override
	public Locations create(Locations location) {
		return locationsRepository.save(location);
	}

	@Override
	public List<Locations> getLastLoc() {
		return locationsRepository.findLastLocationsByDriver();
	}

}
