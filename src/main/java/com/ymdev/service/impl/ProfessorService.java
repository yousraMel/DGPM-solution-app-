package com.ymdev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymdev.models.Professor;
import com.ymdev.repositories.IProfessorRepository;
import com.ymdev.service.IProfessorService;

@Service
public class ProfessorService implements IProfessorService {

	@Autowired
	private IProfessorRepository repository;
	
	public IProfessorRepository getRepoc() {
		return repository;
	}

	public void setRepoc(IProfessorRepository repository) {
		this.repository = repository;
	}

	@Override
	public void saveOrUpdate(Professor c) {
		repository.save(c);
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

	@Override
	public Professor getById(long id) {
		return repository.getOne(id);
	}

	@Override
	public List<Professor> findAll() {
		return repository.findAll();
	}

	@Override
	public Professor getByMatricul(int matricul) {
		return repository.findByMatricul(matricul).get(0);	}


}
