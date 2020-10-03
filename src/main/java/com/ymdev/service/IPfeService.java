package com.ymdev.service;

import java.util.List;

import com.ymdev.models.Pfe;
import com.ymdev.models.Student;

public interface IPfeService {
	
	public void saveOrUpdate(Pfe c);
	public void delete(long id);
	public List<Pfe> findAll();
	public Pfe getById(long id);
	public Pfe getByStudent(Student student);


}
