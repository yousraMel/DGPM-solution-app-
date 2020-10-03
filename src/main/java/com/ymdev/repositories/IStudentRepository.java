package com.ymdev.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ymdev.models.Student;


@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
	
	public List<Student> findBystudentIDCardAndPassword(int card, String password);
 
}

