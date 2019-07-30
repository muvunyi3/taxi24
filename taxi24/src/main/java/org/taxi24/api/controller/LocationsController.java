package org.taxi24.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.taxi24.api.model.Locations;
import org.taxi24.api.service.LocationsService;

@RestController
@RequestMapping("/api/locations")
public class LocationsController {
	private final static Logger LOGGER = LoggerFactory.getLogger(LocationsController.class);
	@Autowired
	private LocationsService locationsService;

	@GetMapping
	public List<Locations> list(){
		return locationsService.list();
	}
	
	//@PostMapping
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Locations create(@RequestBody Locations locations) {
		LOGGER.info("1. Locations: " + locations.toString());
		Locations rep = locationsService.create(locations); 
		return rep;
	}
	
}
