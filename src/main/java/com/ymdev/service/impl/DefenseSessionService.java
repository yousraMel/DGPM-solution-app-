package com.ymdev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymdev.models.DefenseSession;
import com.ymdev.repositories.IDefenseRepository;
import com.ymdev.service.IDefenseSessionService;

@Service
public class DefenseSessionService implements IDefenseSessionService {

	@Autowired
	private IDefenseRepository repository;
	
	public IDefenseRepository getRepoc() {
		return repository;
	}

	public void setRepoc(IDefenseRepository repository) {
		this.repository = repository;
	}

	@Override
	public void saveOrUpdate(DefenseSession c) {
		repository.save(c);
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

	@Override
	public DefenseSession getById(long id) {
		return repository.getOne(id);
	}

	@Override
	public List<DefenseSession> findAll() {
		return repository.findAll();
	}


}
