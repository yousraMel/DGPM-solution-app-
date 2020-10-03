package com.ymdev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymdev.models.Pfe;
import com.ymdev.models.Student;
import com.ymdev.repositories.IPfeRepository;
import com.ymdev.service.IPfeService;

@Service
public class PfeService implements IPfeService {

	@Autowired
	private IPfeRepository repository;
	
	public IPfeRepository getRepoc() {
		return repository;
	}

	public void setRepoc(IPfeRepository repository) {
		this.repository = repository;
	}

	@Override
	public void saveOrUpdate(Pfe c) {
		repository.save(c);
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

	@Override
	public Pfe getById(long id) {
		return repository.getOne(id);
	}

	@Override
	public List<Pfe> findAll() {
		return repository.findAll();
	}

	@Override
	public Pfe getByStudent(Student student) {
		return repository.findByStudent(student).get(0);
	}


}
