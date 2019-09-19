package com.projet_6.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.projet_6.entity.Way;

public interface WayRepository extends JpaRepository<Way, Long> {
	public Page<Way> findByNameWayContains(String mc, Pageable pageable);

}