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
import org.taxi24.api.service.DriversService;

@RestController
@RequestMapping("/api/drivers")
public class DriversController {
	private final static Logger LOGGER = LoggerFactory.getLogger(DriversController.class);
	@Autowired
	private DriversService driversService;

	@GetMapping
	public List<Drivers> list(){
		return driversService.list();
	}
	
	//@PostMapping
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Drivers create(@RequestBody Drivers driver) {
		LOGGER.info("1. Driver: " + driver.toString());
		Drivers rep = driversService.create(driver);
		LOGGER.info("2. create return: " + rep.toString() ); 
		return rep;
	}
	
	@GetMapping("/{id}")
	public Drivers get(@PathVariable("id") Long id) {
		return driversService.get(id);
	}
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(path = "/3km", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Drivers closestDrivers(@RequestBody Locations location) {
		LOGGER.info("1. Location: " + location.toString());
		return driversService.closestDrivers(location); 
		 
	}
}
