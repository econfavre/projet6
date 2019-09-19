package com.projet_6.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.projet_6.entity.Sector;

public interface SectorRepository extends JpaRepository<Sector, Long> {
	public Page<Sector> findByNameSectorContains(String mc, Pageable pageable);

}