package org.taxi24.api.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.taxi24.api.model.Trips;

@Component
public interface TripsService {
	public List<Trips> listTrips();

	public void createTrip(Trips trip);

	public Trips completeTrip(Long Id);
}
