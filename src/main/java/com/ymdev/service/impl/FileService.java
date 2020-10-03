package com.ymdev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.ymdev.models.File;
import com.ymdev.repositories.IFileRepository;
import com.ymdev.service.IFileService;
import com.ymdev.service.IFileStorageService;
import com.ymdev.service.IPfeService;
import com.ymdev.web.FileUploadController;

@Service
public class FileService implements IFileService {
	
	@Autowired
	private IFileRepository repo;
	
	@Autowired
	  IFileStorageService storageService;
	
	@Autowired
	  IPfeService pfService;

	@Override
	public File saveOrUpdate(File file) {
		return repo.save(file);
	}

	@Override
	public void delete(Long idFile) {
		repo.delete(repo.getOne(idFile));

	}

	@Override
	public File getById(Long idFile) {
		return repo.getOne(idFile);
	}

	@Override
	public File getByName(String fileName) {
		return repo.getByName(fileName);
	}

	@Override
	public List<File> getAll() {
		return repo.findAll();
	}

	@Override
	public File loadFileUrl(String filename) {
		File image  = repo.getByName(filename);
		Resource file = storageService.load(filename);
	     filename = file.getFilename().toString();
	    String url = MvcUriComponentsBuilder
		          .fromMethodName(FileUploadController.class, "getFile", file.getFilename().toString()).build().toString();
	    image.setUrl(url);	    
	    return image;
	}

	@Override
	public long coutFiles() {
		return repo.count();
	}

	@Override
	public List<File> getByPfe(long pfeId) {
		return repo.getByPfe(pfService.getById(pfeId));
	}

}
