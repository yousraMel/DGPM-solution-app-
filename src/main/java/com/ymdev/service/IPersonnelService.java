package com.ymdev.service;

import java.util.List;

import com.ymdev.models.Personnel;

public interface IPersonnelService {
	
	public void saveOrUpdate(Personnel c);
	public void delete(long id);
	public List<Personnel> findAll();
	Personnel getById(long id);

}
