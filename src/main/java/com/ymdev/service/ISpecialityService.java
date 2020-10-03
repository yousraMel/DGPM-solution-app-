package com.ymdev.service;

import java.util.List;

import com.ymdev.models.Speciality;

public interface ISpecialityService {
	
	public void saveOrUpdate(Speciality c);
	public void delete(long id);
	public List<Speciality> findAll();
	public Speciality getById(long id);

}
