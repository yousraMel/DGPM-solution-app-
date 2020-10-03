package com.ymdev.service;

import java.util.List;

import com.ymdev.models.Meeting;
import com.ymdev.models.Pfe;

public interface IMeetingService {
	
	public void saveOrUpdate(Meeting c);
	public void delete(long id);
	public Meeting getById(long id);
	public List<Meeting> findAll();
	public List<Meeting> findByPfe(Pfe pfe);
}
