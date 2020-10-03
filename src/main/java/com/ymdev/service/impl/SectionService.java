package com.ymdev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymdev.models.Section;
import com.ymdev.repositories.ISectionRepository;
import com.ymdev.service.ISectionService;

@Service
public class SectionService implements ISectionService {

	@Autowired
	private ISectionRepository repository;
	
	public ISectionRepository getRepoc() {
		return repository;
	}

	public void setRepoc(ISectionRepository repository) {
		this.repository = repository;
	}

	@Override
	public void saveOrUpdate(Section c) {
		repository.save(c);
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

	@Override
	public Section getById(long id) {
		return repository.getOne(id);
	}

	@Override
	public List<Section> findAll() {
		return repository.findAll();
	}


}
