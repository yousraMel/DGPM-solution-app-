package com.ymdev.service;

import java.util.List;

import com.ymdev.models.Professor;
import com.ymdev.models.Student;

public interface IProfessorService {
	
	public void saveOrUpdate(Professor c);
	public void delete(long id);
	public Professor getById(long id);
	public List<Professor> findAll();
	public Professor getByMatricul(int matricul);

}
