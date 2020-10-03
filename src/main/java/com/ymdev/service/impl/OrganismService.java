package com.ymdev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymdev.models.Organism;
import com.ymdev.repositories.IOrganismRepository;
import com.ymdev.service.IOrganismService;

@Service
public class OrganismService implements IOrganismService {

	@Autowired
	private IOrganismRepository repository;
	
	public IOrganismRepository getRepoc() {
		return repository;
	}

	public void setRepoc(IOrganismRepository repository) {
		this.repository = repository;
	}

	@Override
	public void saveOrUpdate(Organism c) {
		repository.save(c);
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

	@Override
	public Organism getById(long id) {
		return repository.getOne(id);
	}

	@Override
	public List<Organism> findAll() {
		return repository.findAll();
	}


}
