package com.ymdev.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ymdev.models.Pfe;
import com.ymdev.models.Student;


@Repository
public interface IPfeRepository extends JpaRepository<Pfe, Long> {
	
	public List<Pfe> findByStudent(Student student);
 
}

