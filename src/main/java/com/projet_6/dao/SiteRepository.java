package com.projet_6.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.projet_6.entity.Site;

public interface SiteRepository extends JpaRepository<Site, Long> {
	public Page<Site> findByNameSiteContains(String mc, Pageable pageable);

	// public Page<Site> findByName(String nameSite);
}
