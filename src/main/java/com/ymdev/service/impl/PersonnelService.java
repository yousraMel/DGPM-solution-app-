package com.ymdev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymdev.models.Personnel;
import com.ymdev.repositories.IPersonnelRepository;
import com.ymdev.service.IPersonnelService;

@Service
public class PersonnelService implements IPersonnelService {

	@Autowired
	private IPersonnelRepository repository;
	
	public IPersonnelRepository getRepoc() {
		return repository;
	}

	public void setRepoc(IPersonnelRepository repository) {
		this.repository = repository;
	}

	@Override
	public void saveOrUpdate(Personnel c) {
		repository.save(c);
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

	@Override
	public Personnel getById(long id) {
		return repository.getOne(id);
	}

	@Override
	public List<Personnel> findAll() {
		return repository.findAll();
	}


}
