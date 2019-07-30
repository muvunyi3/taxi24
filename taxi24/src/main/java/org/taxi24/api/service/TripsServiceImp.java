package org.taxi24.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taxi24.api.model.Trips;
import org.taxi24.api.repositories.TripsRepository;
@Service
public class TripsServiceImp implements TripsService {


	@Autowired
	private TripsRepository tripRepository;
	@Override
	public List<Trips> listTrips(){
		return tripRepository.findByStatus(true);
	}
	

	@Override
	public void createTrip(Trips trip) {
		tripRepository.save(trip);
	}


	@Override
	public Trips completeTrip(Long id) {
		
		Trips trip = tripRepository.findOne(id);
		trip.setTripId(id);
		trip.setStatus(false);
		trip.setCompleteDate(new Date());
		return tripRepository.save(trip);
	}
	

	

}
