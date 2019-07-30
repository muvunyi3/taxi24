package org.taxi24.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.taxi24.api.model.Drivers;
import org.taxi24.api.model.Locations;
import org.taxi24.api.model.Riders;
import org.taxi24.api.service.DriversService;
import org.taxi24.api.service.RidersService;

@RestController
@RequestMapping("/api/riders")
public class RidersController {

	private final static Logger LOGGER = LoggerFactory.getLogger(RidersController.class);
	@Autowired
	private RidersService ridersService;
	@Autowired
	private DriversService driversService;
	@GetMapping
	public List<Riders> list(){
		return ridersService.list();
	}
	
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Riders create(@RequestBody Riders riders) {
		LOGGER.info("1. Riders: " + riders.toString());
		return ridersService.create(riders); 
		 
	}
	
	@GetMapping("/{id}")
	public Riders get(@PathVariable("id") Long id) {
		return ridersService.get(id);
	}
	



	@PostMapping(path = "/close", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Drivers closestDrivers(@RequestBody Locations locName) {
		LOGGER.info("1. Location: " + locName.getLocName());
		return driversService.closestToRiders(locName.getLocName()); 
		 
	}

}
