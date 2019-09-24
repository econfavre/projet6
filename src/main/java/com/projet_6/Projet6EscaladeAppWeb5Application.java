package com.projet_6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projet_6.dao.SiteRepository;
//import com.projet_6.entity.Member;
//import com.projet_6.entity.Sector;
//import com.projet_6.entity.Site;

@SpringBootApplication
public class Projet6EscaladeAppWeb5Application implements CommandLineRunner {

	@Autowired
	private SiteRepository siteRepository;

//	@Autowired
//	private SectorRepository sector;
//
//	@Autowired
//	private MemberRepository member;
//
//	@Autowired
//	private SiteRepository site;

	public static void main(String[] args) {
		SpringApplication.run(Projet6EscaladeAppWeb5Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		siteRepository.findAll().forEach(s -> {
			System.out.println(s.getNameSite());
		});

	}

//		// Clean the database on start up
//		this.sector.deleteAllInBatch();
//		this.site.deleteAllInBatch();
//
//		Member member1 = new Member("Rachid", "riendutout@gmail.com", "12345678", true);
//		Member member2 = new Member("Eliot", "impossible@google.com", "erftew", true);
//
//		this.member.save(member1);
//		this.member.save(member2);
//
//		// Create two managers
//		Site site1 = new Site(2147483649L, "Vallee Bleue", "Nord", "Italie", "Site complexe ...", member1);
//		Site site2 = new Site(2147483650L, "La Rapide", "Sud Est", "France", "Echappee belle", member2);
//
//		// Persist the managers on database
//		this.site.save(site1);
//		this.site.save(site2);
//
//		// Create four projects
//		Sector sector1 = new Sector(12345L, "Sector 1", "Magnifique", site1);
//		Sector sector2 = new Sector(12346L, "Sector 2 ", "Grandiose", site1);
//		Sector sector3 = new Sector(12347L, "Sector 3", "Immense", site2);
//		Sector sector4 = new Sector(12348L, "Sector 4", "Difficile", site2);
//
//		// Persist the projects on database
//		this.sector.save(sector1);
//		this.sector.save(sector2);
//		this.sector.save(sector3);
//		this.sector.save(sector4);
//
//		// Change the manager for project 1 and project 2.
//		sector1.setSite(site2);
//		sector2.setSite(site2);
//
//		// Persist the changes to database
//		this.sector.save(sector1);
//		this.sector.save(sector2);
//
//		// Delete manager 1 from database
//		this.site.delete(site1);
//
//	}

}
