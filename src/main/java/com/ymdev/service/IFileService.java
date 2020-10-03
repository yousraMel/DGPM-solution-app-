package com.ymdev.service;

import java.util.List;

import com.ymdev.models.File;


public interface IFileService {
	
	  public File saveOrUpdate(File File);
	  public void delete  (Long idFile);
	  public File getById(Long idFile);
	  public File getByName(String fileName);
	  public List<File> getAll();
	  public List<File> getByPfe(long idpfe);
	  public File loadFileUrl(String filename);
	  public long coutFiles();
}
