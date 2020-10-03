package com.ymdev.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ymdev.models.File;
import com.ymdev.models.Pfe;

@Repository
public interface IFileRepository  extends JpaRepository<File, Long>{
	
	File getByName(String filename);
	List<File> getByPfe(Pfe pfe);

}
