package com.ymdev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ymdev.models.Section;


@Repository
public interface ISectionRepository extends JpaRepository<Section, Long> {
 
}

