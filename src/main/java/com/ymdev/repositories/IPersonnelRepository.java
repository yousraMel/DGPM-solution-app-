package com.ymdev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ymdev.models.Personnel;


@Repository
public interface IPersonnelRepository extends JpaRepository<Personnel, Long> {
 
}

