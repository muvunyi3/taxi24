package org.taxi24.api.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taxi24.api.controller.DriversController;
import org.taxi24.api.model.Drivers;
import org.taxi24.api.model.Locations;
import org.taxi24.api.repositories.DriversRepository;
import org.taxi24.api.util.LocationMatrix;

@Service
public class DriversServiceImp implements DriversService {

	private final static Logger LOGGER = LoggerFactory.getLogger(DriversServiceImp.class);
	@Autowired
	private DriversRepository driverRepository;
	@Autowired
	private LocationsService locationsService;
	@Autowired
	LocationMatrix matrix;
	@Override
	public List<Drivers> list() {
		return driverRepository.findAll();
	}

	@Override
	public Drivers create(Drivers driver) {
		LOGGER.info("3. driver :" + driver) ;
		Drivers dr = null;
		try {
			dr = driverRepository.save(driver);
		} catch (Exception e) {
			LOGGER.info("4. errorMessage :" + e.getMessage()) ;
		}
		return dr;
	}

	@Override
	public Drivers get(Long id) {
		return driverRepository.findOne(id);
	}

	@Override
	public Drivers closestDrivers(Locations location) {
		String ridersLocation = location.getLocName();
		List<Locations> locList = locationsService.getLastLoc();
		for(Locations loc: locList)
		{			
			String driverLocation = loc.getLocName();
			//call to Google Distance Matrix API or MapQuest RouteMatrix
			// params ridersLocation and driverLocation
			matrix.getDistance(ridersLocation, driverLocation);
		}
		
		return null;
	}
	
	@Override
	public Drivers closestToRiders(String locName) {
		String ridersLocation = locName;
		List<Locations> locList = locationsService.getLastLoc();
		LOGGER.info("1. Location List :" + locList.toString()) ;
		for(Locations loc: locList)
		{			
			LOGGER.info("2. Location :" + loc.toString()) ;
			LOGGER.info("3. Location name :" + loc.getLocName()) ;
			String driverLocation = loc.getLocName();
			//call to Google Distance Matrix API or MapQuest RouteMatrix
			// params ridersLocation and driverLocation
			matrix.getDistance(ridersLocation, driverLocation);
		}
		
		return null;
	}

}
