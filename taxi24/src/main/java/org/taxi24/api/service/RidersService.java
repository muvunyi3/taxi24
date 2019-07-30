package org.taxi24.api.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.taxi24.api.model.Riders;


@Component
public interface RidersService {

	public List<Riders> list();
	
	public Riders create(Riders riders);
	
	public Riders get(Long id);
}
