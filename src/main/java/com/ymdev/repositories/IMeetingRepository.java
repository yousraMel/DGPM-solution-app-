package com.ymdev.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ymdev.models.Meeting;
import com.ymdev.models.Pfe;


@Repository
public interface IMeetingRepository extends JpaRepository<Meeting, Long> {

	public List<Meeting> findByPfe(Pfe pfe);
}

