package com.ymdev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ymdev.models.Organism;


@Repository
public interface IOrganismRepository extends JpaRepository<Organism, Long> {
 
}

