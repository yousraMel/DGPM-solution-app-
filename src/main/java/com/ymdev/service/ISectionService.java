package com.ymdev.service;

import java.util.List;

import com.ymdev.models.Section;

public interface ISectionService {
	
	public void saveOrUpdate(Section c);
	public void delete(long id);
	public List<Section> findAll();
	Section getById(long id);

}
