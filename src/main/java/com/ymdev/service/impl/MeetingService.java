package com.ymdev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymdev.models.Meeting;
import com.ymdev.models.Pfe;
import com.ymdev.repositories.IMeetingRepository;
import com.ymdev.service.IMeetingService;

@Service
public class MeetingService implements IMeetingService {

	@Autowired
	private IMeetingRepository repository;
	
	public IMeetingRepository getRepoc() {
		return repository;
	}

	public void setRepoc(IMeetingRepository repository) {
		this.repository = repository;
	}

	@Override
	public void saveOrUpdate(Meeting c) {
		repository.save(c);
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

	@Override
	public Meeting getById(long id) {
		return repository.getOne(id);
	}

	@Override
	public List<Meeting> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Meeting> findByPfe(Pfe pfe) {
		return repository.findByPfe(pfe);
	}


}
