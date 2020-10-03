package com.ymdev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ymdev.models.Speciality;


@Repository
public interface ISpecialityRepository extends JpaRepository<Speciality, Long> {
 
}

