package org.taxi24.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taxi24.api.model.Riders;
import org.taxi24.api.repositories.RidersRepository;

@Service
public class RidersServiceImpl implements RidersService {

	@Autowired
	RidersRepository ridersRepository;
	@Override
	public List<Riders> list() {
		return ridersRepository.findAll();
	}

	@Override
	public Riders create(Riders riders) {
		return ridersRepository.save(riders);
	}

	@Override
	public Riders get(Long id) {
		return ridersRepository.findOne(id);
	}

}
