package com.projet_6.dao;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.projet_6.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	// public Page<Produit> findByDesignationContains(String mc, Pageable pageable);
}