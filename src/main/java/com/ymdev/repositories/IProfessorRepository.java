package com.ymdev.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ymdev.models.Professor;
import com.ymdev.models.Student;


@Repository
public interface IProfessorRepository extends JpaRepository<Professor, Long> {
 
	public List<Professor> findByMatricul(int matricul);
}

