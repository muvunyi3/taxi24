package org.taxi24.api.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.taxi24.api.model.Trips;
import org.taxi24.api.service.TripsService;

@RestController
@RequestMapping("/api/trip")
public class TripsController {
	
	@Autowired
	private TripsService tripsService;
	
	@GetMapping
	public List<Trips> listTrips(){
		return tripsService.listTrips();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void createTrip(@RequestBody Trips trip) {
		tripsService.createTrip(trip);;
	}
	
	@GetMapping("/{id}")
	public Trips completeTrip(@PathVariable("id") Long id) {
		
		return tripsService.completeTrip(id);
	}
		
}
