package com.ymdev.service;

import java.util.List;

import com.ymdev.models.Organism;

public interface IOrganismService {
	
	public void saveOrUpdate(Organism o);
	public void delete(long id);
	public List<Organism> findAll();
	public Organism getById(long id);

}
