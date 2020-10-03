package com.ymdev.service;

import java.util.List;

import com.ymdev.models.Student;

public interface IStudentService {
	
	public void saveOrUpdate(Student c);
	public void delete(long id);
	public List<Student> findAll();
	public Student getById(long id);
	public Student getByCardIdAndPassword(int card, String password);

}
