package com.ymdev.service;

import java.util.List;

import com.ymdev.models.DefenseSession;

public interface IDefenseSessionService {
	
	public void saveOrUpdate(DefenseSession d);
	public void delete(long id);
	public DefenseSession getById(long id);
	public List<DefenseSession> findAll();
	

}
