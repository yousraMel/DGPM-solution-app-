package com.ymdev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymdev.models.Student;
import com.ymdev.repositories.IStudentRepository;
import com.ymdev.service.IStudentService;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private IStudentRepository repository;
	
	public IStudentRepository getRepoc() {
		return repository;
	}

	public void setRepoc(IStudentRepository repository) {
		this.repository = repository;
	}

	@Override
	public void saveOrUpdate(Student c) {
		repository.save(c);
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

	@Override
	public Student getById(long id) {
		return repository.getOne(id);
	}

	@Override
	public List<Student> findAll() {
		return repository.findAll();
	}

	@Override
	public Student getByCardIdAndPassword(int card, String password) {
		
		return repository.findBystudentIDCardAndPassword(card, password).get(0);
	}


}
