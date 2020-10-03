package com.ymdev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymdev.models.Speciality;
import com.ymdev.repositories.ISpecialityRepository;
import com.ymdev.service.ISpecialityService;

@Service
public class SpecialityService implements ISpecialityService {

	@Autowired
	private ISpecialityRepository repository;
	
	public ISpecialityRepository getRepoc() {
		return repository;
	}

	public void setRepoc(ISpecialityRepository repository) {
		this.repository = repository;
	}

	@Override
	public void saveOrUpdate(Speciality c) {
		repository.save(c);
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

	@Override
	public Speciality getById(long id) {
		return repository.getOne(id);
	}

	@Override
	public List<Speciality> findAll() {
		return repository.findAll();
	}


}
